package com.example.spring_boot_testing_app.processing;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Element<ValueType> {

    public abstract String getElementName();

    protected abstract ValueType getValueFromSource(DataSource source);

    protected abstract List<DataSourceType> getSourcePriority();

    protected abstract boolean isElementValid(ValueType keyValue);

    public ValueType getPrioritizedElementValue(Collection<DataSource> dataSources) {
        Map<DataSourceType, ValueType> extractedValues = new HashMap<>();

        for (DataSource source : dataSources) {
            ValueType value = getValueFromSource(source);
            if (isElementValid(value)) {
                extractedValues.put(source.getSourceIdentifier(), value);
            }
        }

        List<DataSourceType> priorityOrder = getSourcePriority();

        for (DataSourceType preferredSource : priorityOrder) {
            if (extractedValues.containsKey(preferredSource)) {
                return extractedValues.get(preferredSource);
            }
        }

        return null;
    }
}