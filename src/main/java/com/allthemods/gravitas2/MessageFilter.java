package com.allthemods.gravitas2;

import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.filter.AbstractFilter;

@Plugin(name = "MessageFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE)
public class MessageFilter extends AbstractFilter {
    @Override
    public Filter.Result filter(LogEvent event) {
        var message = event.getMessage();
        if (StringUtils.startsWith(message.getFormat(), "Tried to add entity ")) {
            return Result.DENY;
        }
        if (StringUtils.startsWith(message.getFormat(), "Unknown custom packet identifier:")) {
            return Result.DENY;
        }
        if (StringUtils.contains(message.getFormat(), "Collision box is too big")) {
            return Result.DENY;
        }
        if (StringUtils.contains(message.getFormat(), "has multiple preferred tags")) {
            return Result.DENY;
        }
        if (StringUtils.startsWith(message.getFormat(), "Closing database connection:")) {
            return Result.DENY;
        } else {
            return Result.NEUTRAL;
        }
    }
}