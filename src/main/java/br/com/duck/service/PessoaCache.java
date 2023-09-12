package br.com.duck.service;

import br.com.duck.model.Pessoa;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaCache {

    private ValueCommands<String, Pessoa> commands;

    PessoaCache(RedisDataSource ds) {
        commands = ds.value(Pessoa.class);
    }

    public Pessoa get(String key) {
        return commands.get(key);
    }

    public void set(String key, Pessoa value) {
        commands.set(key, value);
    }
}
