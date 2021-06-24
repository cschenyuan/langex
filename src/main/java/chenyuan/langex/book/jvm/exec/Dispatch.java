package chenyuan.langex.book.jvm.exec;

public class Dispatch {
    static class QQ {
        public void info() {
            System.out.println("QQ");
        }
    }
    static class TecentQQ extends QQ {
        @Override
        public void info () {
            System.out.println("Tecent QQ");
        }
    }
    static class QireiQQ extends QQ {
        @Override
        public void info () {
            System.out.println("Qirei QQ");
        }
    }
    static class _360 {}

    static class Father {
        public void choice(QQ qq) {
            System.out.print("Father choose ");
            qq.info();
        }

        public void choice(_360 cmn) {
            System.out.println("Father choose 360");
        }
    }

    static class Son extends Father {
        @Override
        public void choice(QQ qq) {
            System.out.print("Son choose ");
            qq.info();
        }

        @Override
        public void choice(_360 cmn) {
            System.out.println("Son choose 360");
        }
    }

    public static void main(String[] arg) {
        Father father = new Father();
        Father son = new Son();
        father.choice(new _360()); // Father choose 360
        son.choice(new QQ()); // Son choose QQ
        QQ tqq = new TecentQQ();
        QQ qqq = new QireiQQ();
        son.choice(tqq); // Son choose Tecent QQ
        father = new Son();
        father.choice(qqq); // Son choose Qirei QQ
    }

}
