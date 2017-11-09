package model.JacksonSerializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import model.Fitness;

public class FitnessDeserializer extends StdDeserializer<Fitness> {

    public FitnessDeserializer() {
        this(null);
    }

    private FitnessDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Fitness deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
        final JsonNode fitnessNode = jp.getCodec().readTree(jp);
        final Fitness fitness = new Fitness();
        fitness.setHeartbeat(fitnessNode.get("heartbeat").asInt());
        fitness.setNumberOfSteps(fitnessNode.get("numberOfSteps").asInt());
        return fitness;
    }
}
