package com.atella.java.log;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog4j {
        private static final Logger LOG = LoggerFactory.getLogger(TestLog4j.class);
        private static Level level = Level.toLevel(Level.DEBUG_INT);
        static {
            LogManager.getRootLogger().setLevel(level);
        }
        /** 包的等级
         * Level level = Level.toLevel(Level.DEBUG);  
         * Logger logger = LogManager.getLogger(“package”);  
         * logger.setLevel(level);
         */
        /**
         * 
         */
        public static void main(String args[]){
            LOG.info("FORMAT ","DEBUG Test");
        }       
        void test(){
                  
         }
}
