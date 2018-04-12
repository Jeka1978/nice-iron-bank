package com.naya.ironbank.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Profile("WINTER_IS_HERE")
public class StrictProphetService implements ProphetService {
    @Override
    public boolean willSurvive(String name) {
        return name.toLowerCase().contains("lanister");
    }

}
