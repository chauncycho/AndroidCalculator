package com.example.calculator;

public class ConvertingUnits {

    static class Length {
        public double MilliToMeter(double milli) {
            return (milli / 1000);
        }

        public double MeterToMilli(double meter) {
            return (meter * 1000);
        }

        public double CentiToMeter(double Centi) {
            return (Centi / 100);
        }

        public double MeterToCenti(double meter) {
            return (meter * 100);
        }

        public double KiloToMeter(double Kilo) {
            return (Kilo * 1000);
        }

        public double MeterToKilo(double meter) {
            return (meter / 1000);
        }

        public double NanoToMeter(double milli) {
            return (milli / 1000000000);
        }

        public double MeterToNano(double meter) {
            return (meter * 1000000000);
        }
    }
}
