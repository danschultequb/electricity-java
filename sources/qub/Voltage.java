package qub;

/**
 * A measurement between two points.
 */
public class Voltage implements ComparableWithError<Voltage>
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

    private final double value;
    private final VoltageUnit units;

    public Voltage(double value, VoltageUnit units)
    {
        PreCondition.assertNotNull(units, "units");

        this.value = value;
        this.units = units;
    }

    public double getValue()
    {
        return this.value;
    }

    public VoltageUnit getUnits()
    {
        return this.units;
    }

    public Voltage convertTo(VoltageUnit destinationUnits)
    {
        PreCondition.assertNotNull(destinationUnits, "destinationUnits");

        Voltage result = this;

        switch (this.getUnits())
        {
            case Millivolts:
                switch (destinationUnits)
                {
                    case Volts:
                        result = new Voltage(this.getValue() * MetricScale.milliToUni, destinationUnits);
                        break;

                    case Kilovolts:
                        result = new Voltage(this.getValue() * MetricScale.milliToKilo, destinationUnits);
                        break;

                    case Megavolts:
                        result = new Voltage(this.getValue() * MetricScale.milliToMega, destinationUnits);
                        break;
                }
                break;

            case Volts:
                switch (destinationUnits)
                {
                    case Millivolts:
                        result = new Voltage(this.getValue() * MetricScale.uniToMilli, destinationUnits);
                        break;

                    case Kilovolts:
                        result = new Voltage(this.getValue() * MetricScale.uniToKilo, destinationUnits);
                        break;

                    case Megavolts:
                        result = new Voltage(this.getValue() * MetricScale.uniToMega, destinationUnits);
                        break;
                }
                break;

            case Kilovolts:
                switch (destinationUnits)
                {
                    case Millivolts:
                        result = new Voltage(this.getValue() * MetricScale.kiloToMilli, destinationUnits);
                        break;

                    case Volts:
                        result = new Voltage(this.getValue() * MetricScale.kiloToUni, destinationUnits);
                        break;

                    case Megavolts:
                        result = new Voltage(this.getValue() * MetricScale.kiloToMega, destinationUnits);
                        break;
                }
                break;

            case Megavolts:
                switch (destinationUnits)
                {
                    case Millivolts:
                        result = new Voltage(this.getValue() * MetricScale.megaToMilli, destinationUnits);
                        break;

                    case Volts:
                        result = new Voltage(this.getValue() * MetricScale.megaToUni, destinationUnits);
                        break;

                    case Kilovolts:
                        result = new Voltage(this.getValue() * MetricScale.megaToKilo, destinationUnits);
                        break;
                }
                break;
        }

        PostCondition.assertNotNull(result, "result");

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

    public Voltage negate()
    {
        final double value = this.getValue();
        final Voltage result = (value == 0 ? this : new Voltage(-value, this.getUnits()));

        PostCondition.assertNotNull(result, "result");

        return result;
    }

    public Voltage plus(Voltage rhs)
    {
        PreCondition.assertNotNull(rhs, "rhs");

        final Voltage result = (rhs.getValue() == 0 ? this : new Voltage(this.getValue() + rhs.convertTo(this.getUnits()).getValue(), this.getUnits()));

        PostCondition.assertNotNull(result, "result");
        PostCondition.assertEqual(this.getUnits(), result.getUnits(), "result.getUnits()");

        return result;
    }

    /**
     * Get the difference between this Voltage and the provided Voltage.
     * @param rhs The Voltage to subtract from this Voltage.
     * @return The difference between this Voltage and the provided Voltage.
     */
    public Voltage minus(Voltage rhs)
    {
        PreCondition.assertNotNull(rhs, "rhs");

        final Voltage result = (rhs.getValue() == 0 ? this : new Voltage(this.getValue() - rhs.convertTo(this.getUnits()).getValue(), this.getUnits()));

        PostCondition.assertNotNull(result, "result");
        PostCondition.assertEqual(this.getUnits(), result.getUnits(), "result.getUnits()");

        return result;
    }

    public Voltage times(double value)
    {
        final Voltage result = (value == 1 ? this : new Voltage(this.getValue() * value, this.getUnits()));

        PostCondition.assertNotNull(result, "result");
        PostCondition.assertEqual(this.getUnits(), result.getUnits(), "result.getUnits()");

        return result;
    }

    public Voltage dividedBy(double rhs)
    {
        PreCondition.assertNotEqual(0.0, rhs, "rhs");

        final Voltage result = (rhs == 1 ? this : new Voltage(this.getValue() / rhs, this.getUnits()));

        PostCondition.assertNotNull(result, "result");

        return result;
    }

    public double dividedBy(Voltage rhs)
    {
        PreCondition.assertNotNull(rhs, "rhs");
        PreCondition.assertNotEqual(0, rhs.getValue(), "rhs.getValue()");

        final Voltage convertedRhs = rhs.convertTo(this.getUnits());
        final double result = this.getValue() / convertedRhs.getValue();

        return result;
    }

    public Voltage round()
    {
        final double roundedValue = Math.round(this.getValue());
        return roundedValue == this.getValue() ? this : new Voltage(roundedValue, this.getUnits());
    }

    public Voltage round(Voltage scale)
    {
        PreCondition.assertNotNull(scale, "scale");
        PreCondition.assertNotEqual(0, scale.getValue(), "scale.getValue()");

        final Voltage convertedLhs = this.convertTo(scale.getUnits());
        final double roundedValue = Math.round(convertedLhs.getValue(), scale.getValue());
        final Voltage result = convertedLhs.getValue() == roundedValue ? convertedLhs : new Voltage(roundedValue, scale.getUnits());

        PostCondition.assertNotNull(result, "result");
        PostCondition.assertEqual(scale.getUnits(), result.getUnits(), "result.getUnits()");

        return result;
    }

    public Voltage round(double scale)
    {
        PreCondition.assertNotEqual(0, scale, "scale");

        final double roundedValue = Math.round(this.getValue(), scale);
        final Voltage result = (this.getValue() == roundedValue ? this : new Voltage(roundedValue, this.getUnits()));

        PostCondition.assertNotNull(result, "result");
        PostCondition.assertEqual(getUnits(), result.getUnits(), "result.getUnits()");

        return result;
    }

    @Override
    public String toString()
    {
        return this.getValue() + " " + this.getUnits();
    }

    public String toString(String format)
    {
        PreCondition.assertNotNull(format, "format");

        return new java.text.DecimalFormat(format).format(this.getValue()) + " " + this.getUnits();
    }

    @Override
    public boolean equals(Object value)
    {
        return value instanceof Voltage && this.equals((Voltage)value);
    }

    public boolean equals(Voltage rhs)
    {
        return rhs != null && rhs.convertTo(this.getUnits()).getValue() == this.getValue();
    }

    @Override
    public int hashCode()
    {
        return Doubles.hashCode(this.toVolts().getValue());
    }

    @Override
    public Comparison compareWith(Voltage value)
    {
        return this.compareTo(value, Voltage.zero);
    }

    @Override
    public Comparison compareTo(Voltage value, Voltage marginOfError)
    {
        PreCondition.assertNotNull(marginOfError, "marginOfError");

        Comparison result;
        if (value == null)
        {
            result = Comparison.GreaterThan;
        }
        else
        {
            final VoltageUnit units = this.getUnits();
            result = Comparison.create(this.getValue() - value.convertTo(units).getValue(), marginOfError.convertTo(units).getValue());
        }

        PostCondition.assertNotNull(result, "result");

        return result;
    }
}
