package Enums;


    public enum BreadSize {
        FOOTLONG("Footlong"),
        SIXINCH("SixInch"),
        NONE("none");

        private final String stringValue;

        private BreadSize(String s) {
            this.stringValue = s;
        }

        public String toString() {
            return this.stringValue;
        }

        public String BreadSize() {
            return this.stringValue;
        }
}
