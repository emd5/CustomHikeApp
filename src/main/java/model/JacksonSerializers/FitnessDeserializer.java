package model.JacksonSerializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import model.Fitness;

public class FitnessDeserializer extends StdDeserializer<Fitness> {

    public FitnessDeserializer() {
        this(null);
    }

    public FitnessDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Fitness deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode fitnessNode = jp.getCodec().readTree(jp);
        Fitness fitness = new Fitness();
        fitness.setHeartbeat(fitnessNode.get("heartbeat").asInt());
        fitness.setNumberOfSteps(fitnessNode.get("numberOfSteps").asInt());
        return fitness;
    }
}
