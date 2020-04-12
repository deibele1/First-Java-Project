package dev.deathstarreactorcore.rawTypes;

import dev.deathstarreactorcore.beans.Persistant;
//Forms creating persistant objects should produce a JSON of the persistant objects raw form.
//The raw form must include a method to covert itself into it's processed object.
public interface Raw {
    public Persistant process();
}