package com.example.spring_boot_testing_app.processing;

public abstract class Element<ValueType> {

    enum Priority {
        JSON,
        XML
    }

    public abstract String getElementName();

    protected abstract ValueType getJsonValue(String vehicleInfo);

    protected abstract ValueType getXMLValue(String orderInfo);

    public ValueType getPrioritizedElementValue(String vehicleInfo, String orderInfo) {
        ValueType jsonKeyValue = getJsonValue(vehicleInfo);
        ValueType xmlKeyValue = getXMLValue(orderInfo);

        if (isElementValid(jsonKeyValue) && isElementValid(xmlKeyValue)) {
            return (Priority.XML.equals(getPriority())) ? xmlKeyValue : jsonKeyValue;
        } else if (!isElementValid(jsonKeyValue) && !isElementValid(xmlKeyValue)) {
            return null;
        } else if (!isElementValid(xmlKeyValue)) {
            return jsonKeyValue;
        } else {
            return xmlKeyValue;
        }
    }

    Priority getPriority() { return Priority.XML; }

    protected abstract boolean isElementValid(ValueType keyValue);
}