package Main.Practise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args)
    {
        log.info("hello,everybody!");
        log.error(log.getName());
        log.warn(log.getClass().toString());
        log.debug("debug");

    }
}
