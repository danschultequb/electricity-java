package qub;

public interface CurrentTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(Current.class, () ->
        {
            runner.test("zero", (Test test) ->
            {
                final Current zero = Current.zero;
                test.assertNotNull(zero);
                test.assertEqual(0, zero.getValue());
                test.assertEqual(CurrentUnit.Amperes, zero.getUnits());
            });

            runner.testGroup("create(double,CurrentUnit)", () ->
            {
                final Action3<Double,CurrentUnit,Throwable> createErrorTest = (Double value, CurrentUnit units, Throwable expected) ->
                {
                    runner.test("with " + English.andList(value, units), (Test test) ->
                    {
                        test.assertThrows(() -> Current.create(value, units),
                            expected);
                    });
                };

                createErrorTest.run(0.0, null, new PreConditionFailure("units cannot be null."));

                final Action2<Double,CurrentUnit> createTest = (Double value, CurrentUnit units) ->
                {
                    runner.test("with " + English.andList(value, units), (Test test) ->
                    {
                        final Current current = Current.create(value, units);
                        test.assertNotNull(current);
                        test.assertEqual(value, current.getValue());
                        test.assertEqual(units, current.getUnits());
                    });
                };

                createTest.run(0.0, CurrentUnit.Amperes);
                createTest.run(1.0, CurrentUnit.Milliamperes);
            });

            runner.testGroup("milliamperes(double)", () ->
            {
                final Action1<Double> milliamperesTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        final Current current = Current.milliamperes(value);
                        test.assertNotNull(current);
                        test.assertEqual(value, current.getValue());
                        test.assertEqual(CurrentUnit.Milliamperes, current.getUnits());
                    });
                };

                milliamperesTest.run(-1.0);
                milliamperesTest.run(0.0);
                milliamperesTest.run(10.0);
            });

            runner.testGroup("amperes(double)", () ->
            {
                final Action1<Double> amperesTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        final Current current = Current.amperes(value);
                        test.assertNotNull(current);
                        test.assertEqual(value, current.getValue());
                        test.assertEqual(CurrentUnit.Amperes, current.getUnits());
                    });
                };

                amperesTest.run(-1.0);
                amperesTest.run(0.0);
                amperesTest.run(10.0);
            });

            runner.testGroup("kiloamperes(double)", () ->
            {
                final Action1<Double> kiloamperesTest = (Double value) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        final Current current = Current.kiloamperes(value);
                        test.assertNotNull(current);
                        test.assertEqual(value, current.getValue());
                        test.assertEqual(CurrentUnit.Kiloamperes, current.getUnits());
                    });
                };

                kiloamperesTest.run(-1.0);
                kiloamperesTest.run(0.0);
                kiloamperesTest.run(10.0);
            });

            runner.testGroup("convertTo(CurrentUnit)", () ->
            {
                final Action3<Current,CurrentUnit,Throwable> convertToErrorTest = (Current current, CurrentUnit units, Throwable expected) ->
                {
                    runner.test("with " + English.andList(current, units), (Test test) ->
                    {
                        test.assertThrows(() -> current.convertTo(units), expected);
                    });
                };

                convertToErrorTest.run(Current.zero, null, new PreConditionFailure("units cannot be null."));

                final Action3<Current,CurrentUnit,Current> convertToTest = (Current current, CurrentUnit units, Current expected) ->
                {
                    runner.test("with " + English.andList(current, units), (Test test) ->
                    {
                        final Current converted = current.convertTo(units);
                        test.assertNotNull(converted);
                        test.assertEqual(expected.getUnits(), converted.getUnits());
                        test.assertEqual(expected.getValue(), converted.getValue());
                    });
                };

                convertToTest.run(Current.milliamperes(1), CurrentUnit.Milliamperes, Current.milliamperes(1));
                convertToTest.run(Current.milliamperes(2), CurrentUnit.Amperes, Current.amperes(0.002));
                convertToTest.run(Current.milliamperes(3), CurrentUnit.Kiloamperes, Current.kiloamperes(0.000003));

                convertToTest.run(Current.amperes(1), CurrentUnit.Milliamperes, Current.milliamperes(1000));
                convertToTest.run(Current.amperes(2), CurrentUnit.Amperes, Current.amperes(2));
                convertToTest.run(Current.amperes(3), CurrentUnit.Kiloamperes, Current.kiloamperes(0.003));

                convertToTest.run(Current.kiloamperes(1), CurrentUnit.Milliamperes, Current.milliamperes(1000000));
                convertToTest.run(Current.kiloamperes(2), CurrentUnit.Amperes, Current.amperes(2000));
                convertToTest.run(Current.kiloamperes(3), CurrentUnit.Kiloamperes, Current.kiloamperes(3));
            });

            runner.testGroup("toMilliamperes()", () ->
            {
                final Action2<Current,Double> toMilliamperesTest = (Current current, Double expectedValue) ->
                {
                    runner.test("with " + current, (Test test) ->
                    {
                        final Current convertedCurrent = current.toMilliamperes();
                        test.assertNotNull(convertedCurrent);
                        test.assertEqual(CurrentUnit.Milliamperes, convertedCurrent.getUnits());
                        test.assertEqual(expectedValue, convertedCurrent.getValue());
                    });
                };

                toMilliamperesTest.run(Current.milliamperes(1), 1.0);
                toMilliamperesTest.run(Current.amperes(2), 2000.0);
                toMilliamperesTest.run(Current.kiloamperes(3), 3000000.0);
            });

            runner.testGroup("toAmperes()", () ->
            {
                final Action2<Current,Double> toAmperesTest = (Current current, Double expectedValue) ->
                {
                    runner.test("with " + current, (Test test) ->
                    {
                        final Current convertedCurrent = current.toAmperes();
                        test.assertNotNull(convertedCurrent);
                        test.assertEqual(CurrentUnit.Amperes, convertedCurrent.getUnits());
                        test.assertEqual(expectedValue, convertedCurrent.getValue());
                    });
                };

                toAmperesTest.run(Current.milliamperes(1), 0.001);
                toAmperesTest.run(Current.amperes(2), 2.0);
                toAmperesTest.run(Current.kiloamperes(3), 3000.0);
            });

            runner.testGroup("toKiloamperes()", () ->
            {
                final Action2<Current,Double> toKiloamperes = (Current current, Double expectedValue) ->
                {
                    runner.test("with " + current, (Test test) ->
                    {
                        final Current convertedCurrent = current.toKiloamperes();
                        test.assertNotNull(convertedCurrent);
                        test.assertEqual(CurrentUnit.Kiloamperes, convertedCurrent.getUnits());
                        test.assertEqual(expectedValue, convertedCurrent.getValue());
                    });
                };

                toKiloamperes.run(Current.milliamperes(1), 0.000001);
                toKiloamperes.run(Current.amperes(2), 0.002);
                toKiloamperes.run(Current.kiloamperes(3), 3.0);
            });
        });
    }
}
