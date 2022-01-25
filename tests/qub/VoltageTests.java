package qub;

public interface VoltageTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(Voltage.class, () ->
        {
            runner.testGroup("millivolts(double)", () ->
            {
                final Action1<Double> millivoltsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        VoltageTests.assertVoltage(test, Voltage.millivolts(value), value, VoltageUnit.Millivolts);
                    });
                };

                millivoltsTest.run(-4.0);
                millivoltsTest.run(0.0);
                millivoltsTest.run(17.0);
            });

            runner.testGroup("volts(double)", () ->
            {
                final Action1<Double> voltsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        VoltageTests.assertVoltage(test, Voltage.volts(value), value, VoltageUnit.Volts);
                    });
                };

                voltsTest.run(-4.0);
                voltsTest.run(0.0);
                voltsTest.run(17.0);
            });

            runner.testGroup("kilovolts(double)", () ->
            {
                final Action1<Double> kilovoltsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        VoltageTests.assertVoltage(test, Voltage.kilovolts(value), value, VoltageUnit.Kilovolts);
                    });
                };

                kilovoltsTest.run(-4.0);
                kilovoltsTest.run(0.0);
                kilovoltsTest.run(17.0);
            });

            runner.testGroup("megavolts(double)", () ->
            {
                final Action1<Double> megavoltsTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        VoltageTests.assertVoltage(test, Voltage.megavolts(value), value, VoltageUnit.Megavolts);
                    });
                };

                megavoltsTest.run(-4.0);
                megavoltsTest.run(0.0);
                megavoltsTest.run(17.0);
            });

            runner.testGroup("convertTo(VoltageUnit)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    final Voltage value = Voltage.volts(3);
                    test.assertThrows(() -> value.convertTo(null),
                        new PreConditionFailure("destinationUnits cannot be null."));
                });

                final Action3<Voltage,VoltageUnit,Double> convertToTest = (Voltage value, VoltageUnit expectedUnits, Double expectedValue) ->
                {
                    runner.test("with " + value + " to " + expectedUnits, (Test test) ->
                    {
                        VoltageTests.assertVoltage(test, value.convertTo(expectedUnits), expectedValue, expectedUnits);
                    });
                };

                convertToTest.run(Voltage.millivolts(373), VoltageUnit.Millivolts, 373.0);
                convertToTest.run(Voltage.millivolts(1500), VoltageUnit.Volts, 1.5);
                convertToTest.run(Voltage.millivolts(3), VoltageUnit.Kilovolts, 0.000003);
                convertToTest.run(Voltage.millivolts(7), VoltageUnit.Megavolts, 0.000000007000000000000001);

                convertToTest.run(Voltage.volts(373), VoltageUnit.Millivolts, 373000.0);
                convertToTest.run(Voltage.volts(1500), VoltageUnit.Volts, 1500.0);
                convertToTest.run(Voltage.volts(3), VoltageUnit.Kilovolts, 0.003);
                convertToTest.run(Voltage.volts(7), VoltageUnit.Megavolts, 0.000007);

                convertToTest.run(Voltage.kilovolts(373), VoltageUnit.Millivolts, 373000000.0);
                convertToTest.run(Voltage.kilovolts(1500), VoltageUnit.Volts, 1500000.0);
                convertToTest.run(Voltage.kilovolts(3), VoltageUnit.Kilovolts, 3.0);
                convertToTest.run(Voltage.kilovolts(7), VoltageUnit.Megavolts, 0.007);

                convertToTest.run(Voltage.megavolts(373), VoltageUnit.Millivolts, 373000000000.0);
                convertToTest.run(Voltage.megavolts(1500), VoltageUnit.Volts, 1500000000.0);
                convertToTest.run(Voltage.megavolts(3), VoltageUnit.Kilovolts, 3000.0);
                convertToTest.run(Voltage.megavolts(7), VoltageUnit.Megavolts, 7.0);
            });

            runner.testGroup("toMillivolts()", () ->
            {
                runner.test("with Millivolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).toMillivolts(), 3, VoltageUnit.Millivolts);
                });

                runner.test("with Volts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.volts(3).toMillivolts(), 3000, VoltageUnit.Millivolts);
                });

                runner.test("with Kilovolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.kilovolts(3).toMillivolts(), 3000000, VoltageUnit.Millivolts);
                });

                runner.test("with Megavolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.megavolts(3).toMillivolts(), 3000000000.0, VoltageUnit.Millivolts);
                });
            });

            runner.testGroup("toVolts()", () ->
            {
                runner.test("with Millivolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).toVolts(), 0.003, VoltageUnit.Volts);
                });

                runner.test("with Volts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.volts(3).toVolts(), 3, VoltageUnit.Volts);
                });

                runner.test("with Kilovolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.kilovolts(3).toVolts(), 3000, VoltageUnit.Volts);
                });

                runner.test("with Megavolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.megavolts(3).toVolts(), 3000000, VoltageUnit.Volts);
                });
            });

            runner.testGroup("toKilovolts()", () ->
            {
                runner.test("with Millivolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).toKilovolts(), 0.000003, VoltageUnit.Kilovolts);
                });

                runner.test("with Volts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.volts(3).toKilovolts(), 0.003, VoltageUnit.Kilovolts);
                });

                runner.test("with Kilovolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.kilovolts(3).toKilovolts(), 3, VoltageUnit.Kilovolts);
                });

                runner.test("with Megavolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.megavolts(3).toKilovolts(), 3000, VoltageUnit.Kilovolts);
                });
            });

            runner.testGroup("toMegavolts()", () ->
            {
                runner.test("with Millivolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).toMegavolts(), 0.0000000030000000000000004, VoltageUnit.Megavolts);
                });

                runner.test("with Volts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.volts(3).toMegavolts(), 0.000003, VoltageUnit.Megavolts);
                });

                runner.test("with Kilovolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.kilovolts(3).toMegavolts(), 0.003, VoltageUnit.Megavolts);
                });

                runner.test("with Megavolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.megavolts(3).toMegavolts(), 3, VoltageUnit.Megavolts);
                });
            });

            runner.testGroup("negate()", () ->
            {
                runner.test("with -1 Volts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.volts(-1).negate(), 1, VoltageUnit.Volts);
                });

                runner.test("with 0 Millivolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(0).negate(), 0, VoltageUnit.Millivolts);
                });

                runner.test("with 10 Megavolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.megavolts(10).negate(), -10, VoltageUnit.Megavolts);
                });
            });

            runner.testGroup("plus(Voltage)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> Voltage.volts(5).plus(null),
                        new PreConditionFailure("rhs cannot be null."));
                });

                runner.test("with negative", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).plus(Voltage.volts(-5)), -4997, VoltageUnit.Millivolts);
                });

                runner.test("with zero", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).plus(Voltage.volts(0)), 3, VoltageUnit.Millivolts);
                });

                runner.test("with positive", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).plus(Voltage.volts(2)), 2003, VoltageUnit.Millivolts);
                });
            });

            runner.testGroup("minus(Voltage)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> Voltage.volts(5).minus(null),
                        new PreConditionFailure("rhs cannot be null."));
                });

                runner.test("with negative", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).minus(Voltage.volts(-5)), 5003, VoltageUnit.Millivolts);
                });

                runner.test("with zero", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).minus(Voltage.volts(0)), 3, VoltageUnit.Millivolts);
                });

                runner.test("with positive", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).minus(Voltage.volts(2)), -1997, VoltageUnit.Millivolts);
                });
            });

            runner.testGroup("times(double)", () ->
            {
                runner.test("with -5", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).times(-5), -15, VoltageUnit.Millivolts);
                });

                runner.test("with -1", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).times(-1), -3, VoltageUnit.Millivolts);
                });

                runner.test("with 0", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).times(0), 0, VoltageUnit.Millivolts);
                });

                runner.test("with 1", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).times(1), 3, VoltageUnit.Millivolts);
                });

                runner.test("with 12", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).times(4), 12, VoltageUnit.Millivolts);
                });
            });

            runner.testGroup("dividedBy(double)", () ->
            {
                runner.test("with -5", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).dividedBy(-5), -0.6, VoltageUnit.Millivolts);
                });

                runner.test("with -1", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).dividedBy(-1), -3, VoltageUnit.Millivolts);
                });

                runner.test("with 0", (Test test) ->
                {
                    test.assertThrows(() -> Voltage.millivolts(3).dividedBy(0),
                        new PreConditionFailure("rhs (0.0) must not be 0.0."));
                });

                runner.test("with 1", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).dividedBy(1), 3, VoltageUnit.Millivolts);
                });

                runner.test("with 4", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(3).dividedBy(4), 0.75, VoltageUnit.Millivolts);
                });
            });

            runner.testGroup("dividedBy(Voltage)", () ->
            {
                runner.test("with -5", (Test test) ->
                {
                    test.assertEqual(-0.6, Voltage.millivolts(3).dividedBy(Voltage.millivolts(-5)));
                });

                runner.test("with -1", (Test test) ->
                {
                    test.assertEqual(-3, Voltage.millivolts(3).dividedBy(Voltage.millivolts(-1)));
                });

                runner.test("with 0", (Test test) ->
                {
                    test.assertThrows(() -> Voltage.millivolts(3).dividedBy(Voltage.volts(0)),
                        new PreConditionFailure("rhs.getValue() (0.0) must not be 0.0."));
                });

                runner.test("with 1", (Test test) ->
                {
                    test.assertEqual(3, Voltage.millivolts(3).dividedBy(Voltage.millivolts(1)));
                });

                runner.test("with 4", (Test test) ->
                {
                    test.assertEqual(0.75, Voltage.millivolts(3).dividedBy(Voltage.millivolts(4)));
                });
            });

            runner.testGroup("round()", () ->
            {
                runner.test("with 0 Millivolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(0).round(), 0, VoltageUnit.Millivolts);
                });

                runner.test("with 1.4999 Kilovolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.kilovolts(1.4999).round(), 1, VoltageUnit.Kilovolts);
                });

                runner.test("with 1.5 Megavolts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.megavolts(1.5).round(), 2, VoltageUnit.Megavolts);
                });

                runner.test("with 2 Volts", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.volts(2).round(), 2, VoltageUnit.Volts);
                });
            });

            runner.testGroup("round(Voltage)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> Voltage.volts(5).round(null),
                        new PreConditionFailure("scale cannot be null."));
                });

                runner.test("with 0 Millivolts and 0 Volt scale", (Test test) ->
                {
                    test.assertThrows(() -> Voltage.millivolts(0).round(Voltage.volts(0)),
                        new PreConditionFailure("scale.getValue() (0.0) must not be 0.0."));
                });

                runner.test("with 0 Millivolts and 1 Volt scale", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(0).round(Voltage.volts(1)), 0, VoltageUnit.Volts);
                });

                runner.test("with 1 Volt and 3 Millivolt scale", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.volts(1).round(Voltage.millivolts(3)), 999, VoltageUnit.Millivolts);
                });
            });

            runner.testGroup("round(double)", () ->
            {
                runner.test("with 0", (Test test) ->
                {
                    test.assertThrows(() -> Voltage.volts(5).round(0),
                        new PreConditionFailure("scale (0.0) must not be 0.0."));
                });

                runner.test("with 0 Millivolts and 1 scale", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.millivolts(0).round(1), 0, VoltageUnit.Millivolts);
                });

                runner.test("with 1 Volt and 3 scale", (Test test) ->
                {
                    VoltageTests.assertVoltage(test, Voltage.volts(1).round(3), 0, VoltageUnit.Volts);
                });
            });

            runner.testGroup("toString(String)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> Voltage.volts(1.23).toString(null),
                        new PreConditionFailure("format cannot be null."));
                });

                runner.test("with " + Strings.escapeAndQuote(""), (Test test) ->
                {
                    test.assertEqual("1.23 Volts", Voltage.volts(1.23).toString(""));
                });

                runner.test("with " + Strings.escapeAndQuote("0"), (Test test) ->
                {
                    test.assertEqual("1 Volts", Voltage.volts(1.23).toString("0"));
                });

                runner.test("with " + Strings.escapeAndQuote("00.0"), (Test test) ->
                {
                    test.assertEqual("01.2 Volts", Voltage.volts(1.23).toString("00.0"));
                });
            });

            runner.testGroup("equals(Object)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertFalse(Voltage.volts(1).equals((Object)null));
                });

                runner.test("with String", (Test test) ->
                {
                    test.assertFalse(Voltage.volts(1).equals((Object)"Voltage"));
                });

                runner.test("with same", (Test test) ->
                {
                    final Voltage voltage = Voltage.volts(2);
                    test.assertTrue(voltage.equals((Object)voltage));
                });

                runner.test("with equal value and units", (Test test) ->
                {
                    test.assertTrue(Voltage.volts(1).equals((Object)Voltage.volts(1)));
                });

                runner.test("with equal converted value and units", (Test test) ->
                {
                    test.assertTrue(Voltage.volts(1).equals((Object)Voltage.millivolts(1000)));
                });

                runner.test("with equal value but different units", (Test test) ->
                {
                    test.assertFalse(Voltage.volts(1).equals((Object)Voltage.kilovolts(1)));
                });

                runner.test("with different value but equal units", (Test test) ->
                {
                    test.assertFalse(Voltage.volts(1).equals((Object)Voltage.volts(2)));
                });
            });

            runner.testGroup("equals(Voltage)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertFalse(Voltage.volts(1).equals((Voltage)null));
                });

                runner.test("with same", (Test test) ->
                {
                    final Voltage voltage = Voltage.volts(2);
                    test.assertTrue(voltage.equals(voltage));
                });

                runner.test("with equal value and units", (Test test) ->
                {
                    test.assertTrue(Voltage.volts(1).equals(Voltage.volts(1)));
                });

                runner.test("with equal converted value and units", (Test test) ->
                {
                    test.assertTrue(Voltage.volts(1).equals(Voltage.millivolts(1000)));
                });

                runner.test("with equal value but different units", (Test test) ->
                {
                    test.assertFalse(Voltage.volts(1).equals(Voltage.kilovolts(1)));
                });

                runner.test("with different value but equal units", (Test test) ->
                {
                    test.assertFalse(Voltage.volts(1).equals(Voltage.volts(2)));
                });
            });

            runner.testGroup("hashCode()", () ->
            {
                runner.test("with same", (Test test) ->
                {
                    final Voltage voltage = Voltage.millivolts(25);
                    test.assertEqual(voltage.hashCode(), voltage.hashCode());
                });

                runner.test("with equal", (Test test) ->
                {
                    test.assertEqual(Voltage.volts(10).hashCode(), Voltage.volts(10).hashCode());
                });

                runner.test("with converted equal", (Test test) ->
                {
                    test.assertEqual(Voltage.volts(500).hashCode(), Voltage.kilovolts(0.5).hashCode());
                });

                runner.test("with different", (Test test) ->
                {
                    test.assertNotEqual(Voltage.millivolts(23).hashCode(), Voltage.volts(1).hashCode());
                });
            });

            runner.testGroup("compareTo(Voltage)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertEqual(Comparison.GreaterThan, Voltage.millivolts(1).compareWith(null));
                });

                runner.test("with less than with equal units", (Test test) ->
                {
                    test.assertEqual(Comparison.LessThan, Voltage.volts(1).compareWith(Voltage.volts(2)));
                });

                runner.test("with less than with different units", (Test test) ->
                {
                    test.assertEqual(Comparison.LessThan, Voltage.millivolts(10).compareWith(Voltage.volts(1)));
                });
            });
        });
    }

    static void assertVoltage(Test test, Voltage voltage, double expectedValue, VoltageUnit expectedUnits)
    {
        test.assertNotNull(voltage);
        test.assertEqual(expectedValue, voltage.getValue());
        test.assertEqual(expectedUnits, voltage.getUnits());
    }
}
