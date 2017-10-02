package pages.Enums;


    public enum BreadSize {
        FOOTLONG("Footlong"),
        SIXINCH("Sixinch"),
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
