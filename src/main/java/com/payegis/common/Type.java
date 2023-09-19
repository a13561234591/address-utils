package com.payegis.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({

        @JsonSubTypes.Type(value = BooleanType.class, name = "boolean"),

        @JsonSubTypes.Type(value = EnumType.class, name = "enum"),

        @JsonSubTypes.Type(value = NullType.class, name = "null"),
        @JsonSubTypes.Type(value = StringType.class, name = "string")
})
@JsonIgnoreProperties({"indexValue"})
public abstract class Type implements Serializable {

    private static final long serialVersionUID = -4496630638699812283L;


    public abstract String getType();

    public abstract Object getOriginalValue();

    public abstract String getHBaseHead();

    public abstract Object getIndexValue();



}
