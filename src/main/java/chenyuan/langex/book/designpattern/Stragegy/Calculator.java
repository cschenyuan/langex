package chenyuan.langex.book.designpattern.Stragegy;

/**
 * Created by chenyuan on 2017/5/3.
 */
public enum Calculator {

    ADD {
        public int exec(int left, int right) {
            return left + right;
        }
    },
    SUB {
        public int exec(int left,int right) {
            return left - right;
        }
    };

    public abstract int exec(int left,int right);
}
