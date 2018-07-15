package guru.springframework.services;

import guru.springframework.commands.UnityOfMeasureCommand;

import java.util.Set;

/**
 * Created by Marcos Almeida on 07/07/2018
 */
public interface UnitOfMeasureService {

    Set<UnityOfMeasureCommand> listAllCommands();
}
