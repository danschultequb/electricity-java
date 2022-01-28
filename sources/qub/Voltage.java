package qub;

/**
 * A measurement between two points.
 */
public class Voltage extends MeasurableValueBase<VoltageUnit, Voltage>
{
    public static final Voltage zero = Voltage.volts(0);

    public static Voltage millivolts(double value)
    {
        return new Voltage(value, VoltageUnit.Millivolts);
    }

    public static Voltage volts(double value)
    {
        return new Voltage(value, VoltageUnit.Volts);
    }

    public static Voltage kilovolts(double value)
    {
        return new Voltage(value, VoltageUnit.Kilovolts);
    }

    public static Voltage megavolts(double value)
    {
        return new Voltage(value, VoltageUnit.Megavolts);
    }

    public static Voltage create(double value, VoltageUnit units)
    {
        return new Voltage(value, units);
    }

    private Voltage(double value, VoltageUnit units)
    {
        super(value, units, Voltage::create, VoltageUnit.Volts);
    }

    @Override
    protected double getConversionMultiplier(VoltageUnit units)
    {
        PreCondition.assertNotNull(units, "units");

        double result = 0;

        switch (this.getUnits())
        {
            case Millivolts:
            {
                switch (units)
                {
                    case Millivolts:
                        result = 1;
                        break;

                    case Volts:
                        result = MetricScale.milliToUni;
                        break;

                    case Kilovolts:
                        result = MetricScale.milliToKilo;
                        break;

                    case Megavolts:
                        result = MetricScale.milliToMega;
                        break;

                    default:
                        MeasurableValueBase.throwUnrecognizedUnitsException(units);
                        break;
                }
            }
            break;

            case Volts:
            {
                switch (units)
                {
                    case Millivolts:
                        result = MetricScale.uniToMilli;
                        break;

                    case Volts:
                        result = 1;
                        break;

                    case Kilovolts:
                        result = MetricScale.uniToKilo;
                        break;

                    case Megavolts:
                        result = MetricScale.uniToMega;
                        break;

                    default:
                        MeasurableValueBase.throwUnrecognizedUnitsException(units);
                        break;
                }
            }
            break;

            case Kilovolts:
            {
                switch (units)
                {
                    case Millivolts:
                        result = MetricScale.kiloToMilli;
                        break;

                    case Volts:
                        result = MetricScale.kiloToUni;
                        break;

                    case Kilovolts:
                        result = 1;
                        break;

                    case Megavolts:
                        result = MetricScale.kiloToMega;
                        break;

                    default:
                        MeasurableValueBase.throwUnrecognizedUnitsException(units);
                        break;
                }
            }
            break;

            case Megavolts:
            {
                switch (units)
                {
                    case Millivolts:
                        result = MetricScale.megaToMilli;
                        break;

                    case Volts:
                        result = MetricScale.megaToUni;
                        break;

                    case Kilovolts:
                        result = MetricScale.megaToKilo;
                        break;

                    case Megavolts:
                        result = 1;
                        break;

                    default:
                        MeasurableValueBase.throwUnrecognizedUnitsException(units);
                        break;
                }
            }
            break;

            default:
                MeasurableValueBase.throwUnrecognizedUnitsException(this.getUnits());
                break;
        }

        PostCondition.assertGreaterThan(result, 0, "result");

        return result;
    }

    public Voltage toMillivolts()
    {
        return this.convertTo(VoltageUnit.Millivolts);
    }

    public Voltage toVolts()
    {
        return this.convertTo(VoltageUnit.Volts);
    }

    public Voltage toKilovolts()
    {
        return this.convertTo(VoltageUnit.Kilovolts);
    }

    public Voltage toMegavolts()
    {
        return this.convertTo(VoltageUnit.Megavolts);
    }
}
