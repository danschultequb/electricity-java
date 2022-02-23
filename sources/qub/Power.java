package qub;

/**
 * The rate at which electrical work is performed.
 */
public class Power extends MeasurableValueBase<PowerUnit, Power>
{
    public static Power zero = Power.watts(0);

    public static Power nanowatts(double value)
    {
        return new Power(value, PowerUnit.Nanowatts);
    }

    public static Power microwatts(double value)
    {
        return new Power(value, PowerUnit.Microwatts);
    }

    public static Power milliwatts(double value)
    {
        return new Power(value, PowerUnit.Milliwatts);
    }

    public static Power watts(double value)
    {
        return new Power(value, PowerUnit.Watts);
    }

    public static Power kilowatts(double value)
    {
        return new Power(value, PowerUnit.Kilowatts);
    }

    public static Power megawatts(double value)
    {
        return new Power(value, PowerUnit.Megawatts);
    }

    public static Power gigawatts(double value)
    {
        return new Power(value, PowerUnit.Gigawatts);
    }

    public static Power terawatts(double value)
    {
        return new Power(value, PowerUnit.Terawatts);
    }

    public static Power petawatts(double value)
    {
        return new Power(value, PowerUnit.Petawatts);
    }

    public static Power create(double value, PowerUnit units)
    {
        return new Power(value, units);
    }

    private Power(double value, PowerUnit units)
    {
        super(value, units, Power::create, PowerUnit.Watts);
    }

    @Override
    protected double getConversionMultiplier(PowerUnit units)
    {
        PreCondition.assertNotNull(units, "units");

        Double result = null;
        switch (this.getUnits())
        {
            case Nanowatts:
            {
                switch (units)
                {
                    case Microwatts:
                        result = MetricScale.nanoToMicro;
                        break;

                    case Milliwatts:
                        result = MetricScale.nanoToMilli;
                        break;

                    case Watts:
                        result = MetricScale.nanoToUni;
                        break;

                    case Kilowatts:
                        result = MetricScale.nanoToKilo;
                        break;

                    case Megawatts:
                        result = MetricScale.nanoToMega;
                        break;

                    case Gigawatts:
                        result = MetricScale.nanoToGiga;
                        break;

                    case Terawatts:
                        result = MetricScale.nanoToTera;
                        break;

                    case Petawatts:
                        result = MetricScale.nanoToPeta;
                        break;
                }
            }
            break;

            case Microwatts:
            {
                switch (units)
                {
                    case Nanowatts:
                        result = MetricScale.microToNano;
                        break;

                    case Milliwatts:
                        result = MetricScale.microToMilli;
                        break;

                    case Watts:
                        result = MetricScale.microToUni;
                        break;

                    case Kilowatts:
                        result = MetricScale.microToKilo;
                        break;

                    case Megawatts:
                        result = MetricScale.microToMega;
                        break;

                    case Gigawatts:
                        result = MetricScale.microToGiga;
                        break;

                    case Terawatts:
                        result = MetricScale.microToTera;
                        break;

                    case Petawatts:
                        result = MetricScale.microToPeta;
                        break;
                }
            }
            break;

            case Milliwatts:
            {
                switch (units)
                {
                    case Nanowatts:
                        result = MetricScale.milliToNano;
                        break;

                    case Microwatts:
                        result = MetricScale.milliToMicro;
                        break;

                    case Watts:
                        result = MetricScale.milliToUni;
                        break;

                    case Kilowatts:
                        result = MetricScale.milliToKilo;
                        break;

                    case Megawatts:
                        result = MetricScale.milliToMega;
                        break;

                    case Gigawatts:
                        result = MetricScale.milliToGiga;
                        break;

                    case Terawatts:
                        result = MetricScale.milliToTera;
                        break;

                    case Petawatts:
                        result = MetricScale.milliToPeta;
                        break;
                }
            }
            break;

            case Watts:
            {
                switch (units)
                {
                    case Nanowatts:
                        result = MetricScale.uniToNano;
                        break;

                    case Microwatts:
                        result = MetricScale.uniToMicro;
                        break;

                    case Milliwatts:
                        result = MetricScale.uniToMilli;
                        break;

                    case Kilowatts:
                        result = MetricScale.uniToKilo;
                        break;

                    case Megawatts:
                        result = MetricScale.uniToMega;
                        break;

                    case Gigawatts:
                        result = MetricScale.uniToGiga;
                        break;

                    case Terawatts:
                        result = MetricScale.uniToTera;
                        break;

                    case Petawatts:
                        result = MetricScale.uniToPeta;
                        break;
                }
            }
            break;

            case Kilowatts:
            {
                switch (units)
                {
                    case Nanowatts:
                        result = MetricScale.kiloToNano;
                        break;

                    case Microwatts:
                        result = MetricScale.kiloToMicro;
                        break;

                    case Milliwatts:
                        result = MetricScale.kiloToMilli;
                        break;

                    case Watts:
                        result = MetricScale.kiloToUni;
                        break;

                    case Megawatts:
                        result = MetricScale.kiloToMega;
                        break;

                    case Gigawatts:
                        result = MetricScale.kiloToGiga;
                        break;

                    case Terawatts:
                        result = MetricScale.kiloToTera;
                        break;

                    case Petawatts:
                        result = MetricScale.kiloToPeta;
                        break;
                }
            }
            break;

            case Megawatts:
            {
                switch (units)
                {
                    case Nanowatts:
                        result = MetricScale.megaToNano;
                        break;

                    case Microwatts:
                        result = MetricScale.megaToMicro;
                        break;

                    case Milliwatts:
                        result = MetricScale.megaToMilli;
                        break;

                    case Watts:
                        result = MetricScale.megaToUni;
                        break;

                    case Kilowatts:
                        result = MetricScale.megaToKilo;
                        break;

                    case Gigawatts:
                        result = MetricScale.megaToGiga;
                        break;

                    case Terawatts:
                        result = MetricScale.megaToTera;
                        break;

                    case Petawatts:
                        result = MetricScale.megaToPeta;
                        break;
                }
            }
            break;

            case Gigawatts:
            {
                switch (units)
                {
                    case Nanowatts:
                        result = MetricScale.gigaToNano;
                        break;

                    case Microwatts:
                        result = MetricScale.gigaToMicro;
                        break;

                    case Milliwatts:
                        result = MetricScale.gigaToMilli;
                        break;

                    case Watts:
                        result = MetricScale.gigaToUni;
                        break;

                    case Kilowatts:
                        result = MetricScale.gigaToKilo;
                        break;

                    case Megawatts:
                        result = MetricScale.gigaToMega;
                        break;

                    case Terawatts:
                        result = MetricScale.gigaToTera;
                        break;

                    case Petawatts:
                        result = MetricScale.gigaToPeta;
                        break;
                }
            }
            break;

            case Terawatts:
            {
                switch (units)
                {
                    case Nanowatts:
                        result = MetricScale.teraToNano;
                        break;

                    case Microwatts:
                        result = MetricScale.teraToMicro;
                        break;

                    case Milliwatts:
                        result = MetricScale.teraToMilli;
                        break;

                    case Watts:
                        result = MetricScale.teraToUni;
                        break;

                    case Kilowatts:
                        result = MetricScale.teraToKilo;
                        break;

                    case Megawatts:
                        result = MetricScale.teraToMega;
                        break;

                    case Gigawatts:
                        result = MetricScale.teraToGiga;
                        break;

                    case Petawatts:
                        result = MetricScale.teraToPeta;
                        break;
                }
            }
            break;

            case Petawatts:
            {
                switch (units)
                {
                    case Nanowatts:
                        result = MetricScale.petaToNano;
                        break;

                    case Microwatts:
                        result = MetricScale.petaToMicro;
                        break;

                    case Milliwatts:
                        result = MetricScale.petaToMilli;
                        break;

                    case Watts:
                        result = MetricScale.petaToUni;
                        break;

                    case Kilowatts:
                        result = MetricScale.petaToKilo;
                        break;

                    case Megawatts:
                        result = MetricScale.petaToMega;
                        break;

                    case Gigawatts:
                        result = MetricScale.petaToGiga;
                        break;

                    case Terawatts:
                        result = MetricScale.petaToTera;
                        break;
                }
            }
            break;
        }

        PostCondition.assertTrue(result != null, "No conversion found from " + this.getUnits() + " to " + units + ".");
        PostCondition.assertGreaterThan(result, 0, "result");

        return result;
    }

    public Power toNanowatts()
    {
        return this.convertTo(PowerUnit.Nanowatts);
    }

    public Power toMicrowatts()
    {
        return this.convertTo(PowerUnit.Microwatts);
    }

    public Power toMilliwatts()
    {
        return this.convertTo(PowerUnit.Milliwatts);
    }

    public Power toWatts()
    {
        return this.convertTo(PowerUnit.Watts);
    }

    public Power toKilowatts()
    {
        return this.convertTo(PowerUnit.Kilowatts);
    }

    public Power toMegawatts()
    {
        return this.convertTo(PowerUnit.Megawatts);
    }

    public Power toGigawatts()
    {
        return this.convertTo(PowerUnit.Gigawatts);
    }

    public Power toTerawatts()
    {
        return this.convertTo(PowerUnit.Terawatts);
    }

    public Power toPetawatts()
    {
        return this.convertTo(PowerUnit.Petawatts);
    }
}
