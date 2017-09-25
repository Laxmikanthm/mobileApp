package util;

/**
 * Created by E001599 on 15-09-2017.
 */
public enum ResultEnum {

        Pass(1),
        Fail(2),
        Skip(3);


        private int value;

        private ResultEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }



