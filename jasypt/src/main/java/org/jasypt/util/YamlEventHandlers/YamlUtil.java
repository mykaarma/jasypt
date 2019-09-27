package org.jasypt.util.YamlEventHandlers;

import java.io.StringReader;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ScalarEvent;

public class YamlUtil {
	// This class is intended to be used only for encrypted strings 
	public static Event getScalarEventFromString(String value) {
        Yaml yaml = new Yaml();
        for(Event e : yaml.parse(new StringReader(value))){
            if (e instanceof ScalarEvent) {
            	// Just a double check if we are indeed returning the desired event.
                if(value.equals( ((ScalarEvent) e).getValue() )) {
                	return e;
                }
            }
		}
        return null;
	}
}
