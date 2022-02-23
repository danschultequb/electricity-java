package qub;

public interface PowerTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(Power.class, () ->
        {
            runner.test("zero", (Test test) ->
            {
                final Power zero = Power.zero;
                test.assertNotNull(zero);
                test.assertEqual(0, zero.getValue());
                test.assertEqual(PowerUnit.Watts, zero.getUnits());
            });

            runner.testGroup("nanowatts(double)", () ->
            {
                final Action1<Double> nanowatts = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        PowerTests.assertPower(test, Power.nanowatts(value), value, PowerUnit.Nanowatts);
                    });
                };

                nanowatts.run(-4.0);
                nanowatts.run(0.0);
                nanowatts.run(17.0);
            });

            runner.testGroup("microwatts(double)", () ->
            {
                final Action1<Double> microwattsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        PowerTests.assertPower(test, Power.microwatts(value), value, PowerUnit.Microwatts);
                    });
                };

                microwattsTest.run(-4.0);
                microwattsTest.run(0.0);
                microwattsTest.run(17.0);
            });

            runner.testGroup("milliwatts(double)", () ->
            {
                final Action1<Double> milliwattsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        PowerTests.assertPower(test, Power.milliwatts(value), value, PowerUnit.Milliwatts);
                    });
                };

                milliwattsTest.run(-4.0);
                milliwattsTest.run(0.0);
                milliwattsTest.run(17.0);
            });

            runner.testGroup("watts(double)", () ->
            {
                final Action1<Double> wattsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        PowerTests.assertPower(test, Power.watts(value), value, PowerUnit.Watts);
                    });
                };

                wattsTest.run(-4.0);
                wattsTest.run(0.0);
                wattsTest.run(17.0);
            });

            runner.testGroup("kilowatts(double)", () ->
            {
                final Action1<Double> kilowattsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        PowerTests.assertPower(test, Power.kilowatts(value), value, PowerUnit.Kilowatts);
                    });
                };

                kilowattsTest.run(-4.0);
                kilowattsTest.run(0.0);
                kilowattsTest.run(17.0);
            });

            runner.testGroup("megawatts(double)", () ->
            {
                final Action1<Double> megawattsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        PowerTests.assertPower(test, Power.megawatts(value), value, PowerUnit.Megawatts);
                    });
                };

                megawattsTest.run(-4.0);
                megawattsTest.run(0.0);
                megawattsTest.run(17.0);
            });

            runner.testGroup("gigawatts(double)", () ->
            {
                final Action1<Double> gigawattsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        PowerTests.assertPower(test, Power.gigawatts(value), value, PowerUnit.Gigawatts);
                    });
                };

                gigawattsTest.run(-4.0);
                gigawattsTest.run(0.0);
                gigawattsTest.run(17.0);
            });

            runner.testGroup("terawatts(double)", () ->
            {
                final Action1<Double> terawattsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        PowerTests.assertPower(test, Power.terawatts(value), value, PowerUnit.Terawatts);
                    });
                };

                terawattsTest.run(-4.0);
                terawattsTest.run(0.0);
                terawattsTest.run(17.0);
            });

            runner.testGroup("convertTo(PowerUnit)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    final Power value = Power.watts(3);
                    test.assertThrows(() -> value.convertTo(null),
                        new PreConditionFailure("units cannot be null."));
                });

                final Action3<Power,PowerUnit,Double> convertToTest = (Power value, PowerUnit expectedUnits, Double expectedValue) ->
                {
                    runner.test("with " + value + " to " + expectedUnits, (Test test) ->
                    {
                        PowerTests.assertPower(test, value.convertTo(expectedUnits), expectedValue, expectedUnits);
                    });
                };

                convertToTest.run(Power.nanowatts(1), PowerUnit.Nanowatts,  1.0);
                convertToTest.run(Power.nanowatts(2), PowerUnit.Microwatts, 0.002);
                convertToTest.run(Power.nanowatts(3), PowerUnit.Milliwatts, 0.000003);
                convertToTest.run(Power.nanowatts(4), PowerUnit.Watts,      0.000000004);
                convertToTest.run(Power.nanowatts(5), PowerUnit.Kilowatts,  0.000000000005);
                convertToTest.run(Power.nanowatts(6), PowerUnit.Megawatts,  0.0000000000000060000000000000005);
                convertToTest.run(Power.nanowatts(7), PowerUnit.Gigawatts,  0.000000000000000007);
                convertToTest.run(Power.nanowatts(8), PowerUnit.Terawatts,  0.000000000000000000008);
                convertToTest.run(Power.nanowatts(9), PowerUnit.Petawatts,  0.000000000000000000000009);

                convertToTest.run(Power.microwatts(1), PowerUnit.Nanowatts, 1000.0);
                convertToTest.run(Power.microwatts(2), PowerUnit.Microwatts, 2.0);
                convertToTest.run(Power.microwatts(3), PowerUnit.Milliwatts, 0.003);
                convertToTest.run(Power.microwatts(4), PowerUnit.Watts,      0.000004);
                convertToTest.run(Power.microwatts(5), PowerUnit.Kilowatts,  0.000000005);
                convertToTest.run(Power.microwatts(6), PowerUnit.Megawatts,  0.000000000006);
                convertToTest.run(Power.microwatts(7), PowerUnit.Gigawatts,  0.000000000000007);
                convertToTest.run(Power.microwatts(8), PowerUnit.Terawatts,  0.000000000000000008);
                convertToTest.run(Power.microwatts(9), PowerUnit.Petawatts,  0.000000000000000000009);

                convertToTest.run(Power.milliwatts(1), PowerUnit.Nanowatts,  1000000.0);
                convertToTest.run(Power.milliwatts(2), PowerUnit.Microwatts, 2000.0);
                convertToTest.run(Power.milliwatts(3), PowerUnit.Milliwatts, 3.0);
                convertToTest.run(Power.milliwatts(4), PowerUnit.Watts,      0.004);
                convertToTest.run(Power.milliwatts(5), PowerUnit.Kilowatts,  0.0000049999999999999996);
                convertToTest.run(Power.milliwatts(6), PowerUnit.Megawatts,  0.000000006000000000000001);
                convertToTest.run(Power.milliwatts(7), PowerUnit.Gigawatts,  0.000000000007);
                convertToTest.run(Power.milliwatts(8), PowerUnit.Terawatts,  0.000000000000008);
                convertToTest.run(Power.milliwatts(9), PowerUnit.Petawatts,  0.000000000000000009000000000000001);

                convertToTest.run(Power.watts(1), PowerUnit.Nanowatts,  1000000000.0);
                convertToTest.run(Power.watts(2), PowerUnit.Microwatts, 2000000.0);
                convertToTest.run(Power.watts(3), PowerUnit.Milliwatts, 3000.0);
                convertToTest.run(Power.watts(4), PowerUnit.Watts,         4.0);
                convertToTest.run(Power.watts(5), PowerUnit.Kilowatts,     0.005);
                convertToTest.run(Power.watts(6), PowerUnit.Megawatts,     0.000006);
                convertToTest.run(Power.watts(7), PowerUnit.Gigawatts,     0.000000007000000000000001);
                convertToTest.run(Power.watts(8), PowerUnit.Terawatts,     0.000000000008);
                convertToTest.run(Power.watts(9), PowerUnit.Petawatts,     0.000000000000009000000000000001);

                convertToTest.run(Power.kilowatts(1), PowerUnit.Nanowatts,  1000000000000.0);
                convertToTest.run(Power.kilowatts(2), PowerUnit.Microwatts, 2000000000.0);
                convertToTest.run(Power.kilowatts(3), PowerUnit.Milliwatts, 3000000.0);
                convertToTest.run(Power.kilowatts(4), PowerUnit.Watts,     4000.0);
                convertToTest.run(Power.kilowatts(5), PowerUnit.Kilowatts,    5.0);
                convertToTest.run(Power.kilowatts(6), PowerUnit.Megawatts,    0.006);
                convertToTest.run(Power.kilowatts(7), PowerUnit.Gigawatts,    0.000007);
                convertToTest.run(Power.kilowatts(8), PowerUnit.Terawatts,    0.000000008);
                convertToTest.run(Power.kilowatts(9), PowerUnit.Petawatts,    0.000000000009);

                convertToTest.run(Power.megawatts(1), PowerUnit.Nanowatts,  1000000000000000.0);
                convertToTest.run(Power.megawatts(2), PowerUnit.Microwatts, 2000000000000.0);
                convertToTest.run(Power.megawatts(3), PowerUnit.Milliwatts, 3000000000.0);
                convertToTest.run(Power.megawatts(4), PowerUnit.Watts,      4000000.0);
                convertToTest.run(Power.megawatts(5), PowerUnit.Kilowatts,  5000.0);
                convertToTest.run(Power.megawatts(6), PowerUnit.Megawatts,  6.0);
                convertToTest.run(Power.megawatts(7), PowerUnit.Gigawatts,  0.007);
                convertToTest.run(Power.megawatts(8), PowerUnit.Terawatts,  0.000008);
                convertToTest.run(Power.megawatts(9), PowerUnit.Petawatts,  0.000000009000000000000001);

                convertToTest.run(Power.gigawatts(1), PowerUnit.Nanowatts,  1000000000000000000.0);
                convertToTest.run(Power.gigawatts(2), PowerUnit.Microwatts, 2000000000000000.0);
                convertToTest.run(Power.gigawatts(3), PowerUnit.Milliwatts, 3000000000000.0);
                convertToTest.run(Power.gigawatts(4), PowerUnit.Watts,      4000000000.0);
                convertToTest.run(Power.gigawatts(5), PowerUnit.Kilowatts,  5000000.0);
                convertToTest.run(Power.gigawatts(6), PowerUnit.Megawatts,  6000.0);
                convertToTest.run(Power.gigawatts(7), PowerUnit.Gigawatts,  7.0);
                convertToTest.run(Power.gigawatts(8), PowerUnit.Terawatts,  0.008);
                convertToTest.run(Power.gigawatts(9), PowerUnit.Petawatts,  0.000009);

                convertToTest.run(Power.terawatts(1), PowerUnit.Nanowatts,  1000000000000000000000.0);
                convertToTest.run(Power.terawatts(2), PowerUnit.Microwatts, 2000000000000000000.0);
                convertToTest.run(Power.terawatts(3), PowerUnit.Milliwatts, 3000000000000000.0);
                convertToTest.run(Power.terawatts(4), PowerUnit.Watts,      4000000000000.0);
                convertToTest.run(Power.terawatts(5), PowerUnit.Kilowatts,  5000000000.0);
                convertToTest.run(Power.terawatts(6), PowerUnit.Megawatts,  6000000.0);
                convertToTest.run(Power.terawatts(7), PowerUnit.Gigawatts,  7000.0);
                convertToTest.run(Power.terawatts(8), PowerUnit.Terawatts,  8.0);
                convertToTest.run(Power.terawatts(9), PowerUnit.Petawatts,  0.009000000000000001);

                convertToTest.run(Power.petawatts(1), PowerUnit.Nanowatts,  1000000000000000000000000.0);
                convertToTest.run(Power.petawatts(2), PowerUnit.Microwatts, 2000000000000000000000.0);
                convertToTest.run(Power.petawatts(3), PowerUnit.Milliwatts, 3000000000000000000.0);
                convertToTest.run(Power.petawatts(4), PowerUnit.Watts,      4000000000000000.0);
                convertToTest.run(Power.petawatts(5), PowerUnit.Kilowatts,  5000000000000.0);
                convertToTest.run(Power.petawatts(6), PowerUnit.Megawatts,  6000000000.0);
                convertToTest.run(Power.petawatts(7), PowerUnit.Gigawatts,  7000000.0);
                convertToTest.run(Power.petawatts(8), PowerUnit.Terawatts,  8000.0);
                convertToTest.run(Power.petawatts(9), PowerUnit.Petawatts,  9.0);
            });

            runner.testGroup("toNanowatts()", () ->
            {
                final Action2<Power,Double> toNanowattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toNanowatts(), expected, PowerUnit.Nanowatts);
                    });
                };

                toNanowattsTest.run(Power.nanowatts(1),                         1.0);
                toNanowattsTest.run(Power.microwatts(2),                     2000.0);
                toNanowattsTest.run(Power.milliwatts(3),                  3000000.0);
                toNanowattsTest.run(Power.watts(4),                    4000000000.0);
                toNanowattsTest.run(Power.kilowatts(5),             5000000000000.0);
                toNanowattsTest.run(Power.megawatts(6),          6000000000000000.0);
                toNanowattsTest.run(Power.gigawatts(7),       7000000000000000000.0);
                toNanowattsTest.run(Power.terawatts(8),    8000000000000000000000.0);
                toNanowattsTest.run(Power.petawatts(9), 8999999999999999000000000.0);
            });

            runner.testGroup("toMicrowatts()", () ->
            {
                final Action2<Power,Double> toMicrowattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toMicrowatts(), expected, PowerUnit.Microwatts);
                    });
                };

                toMicrowattsTest.run(Power.nanowatts(1),                      0.001);
                toMicrowattsTest.run(Power.microwatts(2),                     2.0);
                toMicrowattsTest.run(Power.milliwatts(3),                  3000.0);
                toMicrowattsTest.run(Power.watts(4),                    4000000.0);
                toMicrowattsTest.run(Power.kilowatts(5),             5000000000.0);
                toMicrowattsTest.run(Power.megawatts(6),          6000000000000.0);
                toMicrowattsTest.run(Power.gigawatts(7),       7000000000000000.0);
                toMicrowattsTest.run(Power.terawatts(8),    8000000000000000000.0);
                toMicrowattsTest.run(Power.petawatts(9), 9000000000000000000000.0);
            });

            runner.testGroup("toMilliwatts()", () ->
            {
                final Action2<Power,Double> toMilliwattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toMilliwatts(), expected, PowerUnit.Milliwatts);
                    });
                };

                toMilliwattsTest.run(Power.nanowatts(1),                   0.000001);
                toMilliwattsTest.run(Power.microwatts(2),                  0.002);
                toMilliwattsTest.run(Power.milliwatts(3),                  3.0);
                toMilliwattsTest.run(Power.watts(4),                    4000.0);
                toMilliwattsTest.run(Power.kilowatts(5),             5000000.0);
                toMilliwattsTest.run(Power.megawatts(6),          6000000000.0);
                toMilliwattsTest.run(Power.gigawatts(7),       7000000000000.0);
                toMilliwattsTest.run(Power.terawatts(8),    8000000000000000.0);
                toMilliwattsTest.run(Power.petawatts(9), 9000000000000000000.0);
            });

            runner.testGroup("toWatts()", () ->
            {
                final Action2<Power,Double> toWattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toWatts(), expected, PowerUnit.Watts);
                    });
                };

                toWattsTest.run(Power.nanowatts(1),                0.000000001);
                toWattsTest.run(Power.microwatts(2),               0.000002);
                toWattsTest.run(Power.milliwatts(3),               0.003);
                toWattsTest.run(Power.watts(4),                    4.0);
                toWattsTest.run(Power.kilowatts(5),             5000.0);
                toWattsTest.run(Power.megawatts(6),          6000000.0);
                toWattsTest.run(Power.gigawatts(7),       7000000000.0);
                toWattsTest.run(Power.terawatts(8),    8000000000000.0);
                toWattsTest.run(Power.petawatts(9), 9000000000000000.0);
            });

            runner.testGroup("toKilowatts()", () ->
            {
                final Action2<Power,Double> toKilowattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toKilowatts(), expected, PowerUnit.Kilowatts);
                    });
                };

                toKilowattsTest.run(Power.nanowatts(1),             0.000000000001);
                toKilowattsTest.run(Power.microwatts(2),            0.000000002);
                toKilowattsTest.run(Power.milliwatts(3),            0.000003);
                toKilowattsTest.run(Power.watts(4),                 0.004);
                toKilowattsTest.run(Power.kilowatts(5),             5.0);
                toKilowattsTest.run(Power.megawatts(6),          6000.0);
                toKilowattsTest.run(Power.gigawatts(7),       7000000.0);
                toKilowattsTest.run(Power.terawatts(8),    8000000000.0);
                toKilowattsTest.run(Power.petawatts(9), 9000000000000.0);
            });

            runner.testGroup("toMegawatts()", () ->
            {
                final Action2<Power,Double> toMegawattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toMegawatts(), expected, PowerUnit.Megawatts);
                    });
                };

                toMegawattsTest.run(Power.nanowatts(1),          0.000000000000001);
                toMegawattsTest.run(Power.microwatts(2),         0.000000000002);
                toMegawattsTest.run(Power.milliwatts(3),         0.0000000030000000000000004);
                toMegawattsTest.run(Power.watts(4),              0.000004);
                toMegawattsTest.run(Power.kilowatts(5),          0.005);
                toMegawattsTest.run(Power.megawatts(6),          6.0);
                toMegawattsTest.run(Power.gigawatts(7),       7000.0);
                toMegawattsTest.run(Power.terawatts(8),    8000000.0);
                toMegawattsTest.run(Power.petawatts(9), 9000000000.0);
            });

            runner.testGroup("toGigawatts()", () ->
            {
                final Action2<Power,Double> toGigawattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toGigawatts(), expected, PowerUnit.Gigawatts);
                    });
                };

                toGigawattsTest.run(Power.nanowatts(1),       0.000000000000000001);
                toGigawattsTest.run(Power.microwatts(2),      0.000000000000002);
                toGigawattsTest.run(Power.milliwatts(3),      0.000000000003);
                toGigawattsTest.run(Power.watts(4),           0.000000004);
                toGigawattsTest.run(Power.kilowatts(5),       0.0000049999999999999996);
                toGigawattsTest.run(Power.megawatts(6),       0.006);
                toGigawattsTest.run(Power.gigawatts(7),       7.0);
                toGigawattsTest.run(Power.terawatts(8),    8000.0);
                toGigawattsTest.run(Power.petawatts(9), 9000000.0);
            });

            runner.testGroup("toTerawatts()", () ->
            {
                final Action2<Power,Double> toTerawattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toTerawatts(), expected, PowerUnit.Terawatts);
                    });
                };

                toTerawattsTest.run(Power.nanowatts(1),    0.000000000000000000001);
                toTerawattsTest.run(Power.microwatts(2),   0.000000000000000002);
                toTerawattsTest.run(Power.milliwatts(3),   0.0000000000000030000000000000002);
                toTerawattsTest.run(Power.watts(4),        0.000000000004);
                toTerawattsTest.run(Power.kilowatts(5),    0.000000005);
                toTerawattsTest.run(Power.megawatts(6),    0.000006);
                toTerawattsTest.run(Power.gigawatts(7),    0.007);
                toTerawattsTest.run(Power.terawatts(8),    8.0);
                toTerawattsTest.run(Power.petawatts(9), 9000.0);
            });

            runner.testGroup("toPetawatts()", () ->
            {
                final Action2<Power,Double> toPetawattsTest = (Power power, Double expected) ->
                {
                    runner.test("with " + power, (Test test) ->
                    {
                        PowerTests.assertPower(test, power.toPetawatts(), expected, PowerUnit.Petawatts);
                    });
                };

                toPetawattsTest.run(Power.nanowatts(1),  0.000000000000000000000001);
                toPetawattsTest.run(Power.microwatts(2), 0.000000000000000000002);
                toPetawattsTest.run(Power.milliwatts(3), 0.0000000000000000030000000000000002);
                toPetawattsTest.run(Power.watts(4),      0.000000000000004);
                toPetawattsTest.run(Power.kilowatts(5),  0.000000000005);
                toPetawattsTest.run(Power.megawatts(6),  0.000000006000000000000001);
                toPetawattsTest.run(Power.gigawatts(7),  0.000007);
                toPetawattsTest.run(Power.terawatts(8),  0.008);
                toPetawattsTest.run(Power.petawatts(9),  9.0);
            });
        });
    }

    static void assertPower(Test test, Power Power, double expectedValue, PowerUnit expectedUnits)
    {
        test.assertNotNull(Power);
        test.assertEqual(expectedValue, Power.getValue());
        test.assertEqual(expectedUnits, Power.getUnits());
    }
}
