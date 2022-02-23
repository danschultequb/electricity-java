package qub;

public class Current extends MeasurableValueBase<CurrentUnit, Current>
{
    public static final Current zero = Current.amperes(0);

    private Current(double value, CurrentUnit units)
    {
        super(value, units, Current::create, CurrentUnit.Amperes);
    }

    public static Current create(double value, CurrentUnit units)
    {
        return new Current(value, units);
    }

    public static Current milliamperes(double value)
    {
        return Current.create(value, CurrentUnit.Milliamperes);
    }

    public static Current amperes(double value)
    {
        return Current.create(value, CurrentUnit.Amperes);
    }

    public static Current kiloamperes(double value)
    {
        return Current.create(value, CurrentUnit.Kiloamperes);
    }

    @Override
    protected double getConversionMultiplier(CurrentUnit units)
    {
        PreCondition.assertNotNull(units, "units");

        Double result = null;
        switch (this.getUnits())
        {
            case Milliamperes:
                switch (units)
                {
                    case Amperes:
                        result = MetricScale.milliToUni;
                        break;

                    case Kiloamperes:
                        result = MetricScale.milliToKilo;
                        break;
                }
                break;

            case Amperes:
                switch (units)
                {
                    case Milliamperes:
                        result = MetricScale.uniToMilli;
                        break;

                    case Kiloamperes:
                        result = MetricScale.uniToKilo;
                        break;
                }
                break;

            case Kiloamperes:
                switch (units)
                {
                    case Milliamperes:
                        result = MetricScale.kiloToMilli;
                        break;

                    case Amperes:
                        result = MetricScale.kiloToUni;
                        break;
                }
                break;
        }

        PostCondition.assertTrue(result != null, "No conversion found from " + this.getUnits() + " to " + units + ".");
        PostCondition.assertGreaterThan(result, 0, "result");

        return result;
    }

    public Current toMilliamperes()
    {
        return this.convertTo(CurrentUnit.Milliamperes);
    }

    public Current toAmperes()
    {
        return this.convertTo(CurrentUnit.Amperes);
    }

    public Current toKiloamperes()
    {
        return this.convertTo(CurrentUnit.Kiloamperes);
    }
}
