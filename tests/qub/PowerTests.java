package qub;

public interface PowerTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(Power.class, () ->
        {
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
//
//            runner.testGroup("negate()", () ->
//            {
//                runner.test("with -1 Watts", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.watts(-1).negate(), 1, PowerUnit.Watts);
//                });
//
//                runner.test("with 0 milliwatts", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(0).negate(), 0, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with 10 Megawatts", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.megawatts(10).negate(), -10, PowerUnit.Megawatts);
//                });
//            });
//
//            runner.testGroup("plus(Power)", () ->
//            {
//                runner.test("with null", (Test test) ->
//                {
//                    test.assertThrows(() -> Power.watts(5).plus(null),
//                        new PreConditionFailure("rhs cannot be null."));
//                });
//
//                runner.test("with negative", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).plus(Power.watts(-5)), -4997, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with zero", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).plus(Power.watts(0)), 3, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with positive", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).plus(Power.watts(2)), 2003, PowerUnit.Milliwatts);
//                });
//            });
//
//            runner.testGroup("minus(Power)", () ->
//            {
//                runner.test("with null", (Test test) ->
//                {
//                    test.assertThrows(() -> Power.watts(5).minus(null),
//                        new PreConditionFailure("rhs cannot be null."));
//                });
//
//                runner.test("with negative", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).minus(Power.watts(-5)), 5003, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with zero", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).minus(Power.watts(0)), 3, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with positive", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).minus(Power.watts(2)), -1997, PowerUnit.Milliwatts);
//                });
//            });
//
//            runner.testGroup("times(double)", () ->
//            {
//                runner.test("with -5", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).times(-5), -15, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with -1", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).times(-1), -3, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with 0", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).times(0), 0, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with 1", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).times(1), 3, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with 12", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).times(4), 12, PowerUnit.Milliwatts);
//                });
//            });
//
//            runner.testGroup("dividedBy(double)", () ->
//            {
//                runner.test("with -5", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).dividedBy(-5), -0.6, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with -1", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).dividedBy(-1), -3, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with 0", (Test test) ->
//                {
//                    test.assertThrows(() -> Power.milliwatts(3).dividedBy(0),
//                        new PreConditionFailure("rhs (0.0) must not be 0.0."));
//                });
//
//                runner.test("with 1", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).dividedBy(1), 3, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with 4", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(3).dividedBy(4), 0.75, PowerUnit.Milliwatts);
//                });
//            });
//
//            runner.testGroup("dividedBy(Power)", () ->
//            {
//                runner.test("with -5", (Test test) ->
//                {
//                    test.assertEqual(-0.6, Power.milliwatts(3).dividedBy(Power.milliwatts(-5)));
//                });
//
//                runner.test("with -1", (Test test) ->
//                {
//                    test.assertEqual(-3, Power.milliwatts(3).dividedBy(Power.milliwatts(-1)));
//                });
//
//                runner.test("with 0", (Test test) ->
//                {
//                    test.assertThrows(() -> Power.milliwatts(3).dividedBy(Power.watts(0)),
//                        new PreConditionFailure("rhs.getValue() (0.0) must not be 0.0."));
//                });
//
//                runner.test("with 1", (Test test) ->
//                {
//                    test.assertEqual(3, Power.milliwatts(3).dividedBy(Power.milliwatts(1)));
//                });
//
//                runner.test("with 4", (Test test) ->
//                {
//                    test.assertEqual(0.75, Power.milliwatts(3).dividedBy(Power.milliwatts(4)));
//                });
//            });
//
//            runner.testGroup("round()", () ->
//            {
//                runner.test("with 0 milliwatts", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(0).round(), 0, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with 1.4999 Kilowatts", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.kilowatts(1.4999).round(), 1, PowerUnit.Kilowatts);
//                });
//
//                runner.test("with 1.5 Megawatts", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.megawatts(1.5).round(), 2, PowerUnit.Megawatts);
//                });
//
//                runner.test("with 2 Watts", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.watts(2).round(), 2, PowerUnit.Watts);
//                });
//            });
//
//            runner.testGroup("round(Power)", () ->
//            {
//                runner.test("with null", (Test test) ->
//                {
//                    test.assertThrows(() -> Power.watts(5).round(null),
//                        new PreConditionFailure("scale cannot be null."));
//                });
//
//                runner.test("with 0 milliwatts and 0 Volt scale", (Test test) ->
//                {
//                    test.assertThrows(() -> Power.milliwatts(0).round(Power.watts(0)),
//                        new PreConditionFailure("scale.getValue() (0.0) must not be 0.0."));
//                });
//
//                runner.test("with 0 milliwatts and 1 Volt scale", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(0).round(Power.watts(1)), 0, PowerUnit.Watts);
//                });
//
//                runner.test("with 1 Volt and 3 Millivolt scale", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.watts(1).round(Power.milliwatts(3)), 999, PowerUnit.Milliwatts);
//                });
//            });
//
//            runner.testGroup("round(double)", () ->
//            {
//                runner.test("with 0", (Test test) ->
//                {
//                    test.assertThrows(() -> Power.watts(5).round(0),
//                        new PreConditionFailure("scale (0.0) must not be 0.0."));
//                });
//
//                runner.test("with 0 milliwatts and 1 scale", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.milliwatts(0).round(1), 0, PowerUnit.Milliwatts);
//                });
//
//                runner.test("with 1 Volt and 3 scale", (Test test) ->
//                {
//                    PowerTests.assertPower(test, Power.watts(1).round(3), 0, PowerUnit.Watts);
//                });
//            });
//
//            runner.testGroup("toString(String)", () ->
//            {
//                runner.test("with null", (Test test) ->
//                {
//                    test.assertThrows(() -> Power.watts(1.23).toString(null),
//                        new PreConditionFailure("format cannot be null."));
//                });
//
//                runner.test("with " + Strings.escapeAndQuote(""), (Test test) ->
//                {
//                    test.assertEqual("1.23 Watts", Power.watts(1.23).toString(""));
//                });
//
//                runner.test("with " + Strings.escapeAndQuote("0"), (Test test) ->
//                {
//                    test.assertEqual("1 Watts", Power.watts(1.23).toString("0"));
//                });
//
//                runner.test("with " + Strings.escapeAndQuote("00.0"), (Test test) ->
//                {
//                    test.assertEqual("01.2 Watts", Power.watts(1.23).toString("00.0"));
//                });
//            });
//
//            runner.testGroup("equals(Object)", () ->
//            {
//                runner.test("with null", (Test test) ->
//                {
//                    test.assertFalse(Power.watts(1).equals((Object)null));
//                });
//
//                runner.test("with String", (Test test) ->
//                {
//                    test.assertFalse(Power.watts(1).equals((Object)"Power"));
//                });
//
//                runner.test("with same", (Test test) ->
//                {
//                    final Power Power = Power.watts(2);
//                    test.assertTrue(Power.equals((Object)Power));
//                });
//
//                runner.test("with equal value and units", (Test test) ->
//                {
//                    test.assertTrue(Power.watts(1).equals((Object)Power.watts(1)));
//                });
//
//                runner.test("with equal converted value and units", (Test test) ->
//                {
//                    test.assertTrue(Power.watts(1).equals((Object)Power.milliwatts(1000)));
//                });
//
//                runner.test("with equal value but different units", (Test test) ->
//                {
//                    test.assertFalse(Power.watts(1).equals((Object)Power.kilowatts(1)));
//                });
//
//                runner.test("with different value but equal units", (Test test) ->
//                {
//                    test.assertFalse(Power.watts(1).equals((Object)Power.watts(2)));
//                });
//            });
//
//            runner.testGroup("equals(Power)", () ->
//            {
//                runner.test("with null", (Test test) ->
//                {
//                    test.assertFalse(Power.watts(1).equals((Power)null));
//                });
//
//                runner.test("with same", (Test test) ->
//                {
//                    final Power Power = Power.watts(2);
//                    test.assertTrue(Power.equals(Power));
//                });
//
//                runner.test("with equal value and units", (Test test) ->
//                {
//                    test.assertTrue(Power.watts(1).equals(Power.watts(1)));
//                });
//
//                runner.test("with equal converted value and units", (Test test) ->
//                {
//                    test.assertTrue(Power.watts(1).equals(Power.milliwatts(1000)));
//                });
//
//                runner.test("with equal value but different units", (Test test) ->
//                {
//                    test.assertFalse(Power.watts(1).equals(Power.kilowatts(1)));
//                });
//
//                runner.test("with different value but equal units", (Test test) ->
//                {
//                    test.assertFalse(Power.watts(1).equals(Power.watts(2)));
//                });
//            });
//
//            runner.testGroup("hashCode()", () ->
//            {
//                runner.test("with same", (Test test) ->
//                {
//                    final Power Power = Power.milliwatts(25);
//                    test.assertEqual(Power.hashCode(), Power.hashCode());
//                });
//
//                runner.test("with equal", (Test test) ->
//                {
//                    test.assertEqual(Power.watts(10).hashCode(), Power.watts(10).hashCode());
//                });
//
//                runner.test("with converted equal", (Test test) ->
//                {
//                    test.assertEqual(Power.watts(500).hashCode(), Power.kilowatts(0.5).hashCode());
//                });
//
//                runner.test("with different", (Test test) ->
//                {
//                    test.assertNotEqual(Power.milliwatts(23).hashCode(), Power.watts(1).hashCode());
//                });
//            });
//
//            runner.testGroup("compareTo(Power)", () ->
//            {
//                runner.test("with null", (Test test) ->
//                {
//                    test.assertEqual(Comparison.GreaterThan, Power.milliwatts(1).compareWith(null));
//                });
//
//                runner.test("with less than with equal units", (Test test) ->
//                {
//                    test.assertEqual(Comparison.LessThan, Power.watts(1).compareWith(Power.watts(2)));
//                });
//
//                runner.test("with less than with different units", (Test test) ->
//                {
//                    test.assertEqual(Comparison.LessThan, Power.milliwatts(10).compareWith(Power.watts(1)));
//                });
//            });
        });
    }

    static void assertPower(Test test, Power Power, double expectedValue, PowerUnit expectedUnits)
    {
        test.assertNotNull(Power);
        test.assertEqual(expectedValue, Power.getValue());
        test.assertEqual(expectedUnits, Power.getUnits());
    }
}
