import groovy.Duty

import groovy.lang.Script;


abstract public class Main extends Script{
    static duty(Closure cl) {
        cl.delegate = new Duty()
        cl.run()
    }
}