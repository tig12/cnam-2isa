/**
    Utilisation de l'exemple du labyrinthe
    usage : java Main <pattern package>
    ex     : java Main factorymethod
    (<pattern package> = nom d'un sous-package de patterns)
**/

package maze;

import java.util.Arrays;
import java.util.List;

import maze.patterns.basic.*;
import maze.patterns.factorymethod.*;
import maze.patterns.abstractfactory.*;
import maze.patterns.builder.*;
import maze.patterns.prototype.*;

import maze.model.Maze;

public class Main{
    
    private static String[] patterns = {
        "abstractfactory",
        "basic",
        "builder",
        "factorymethod",
        "prototype"
    };
    
    public static void main(String[] args){
        // param check
        String usage = "usage : java Main <pattern>\n<pattern> can be one of : " + Arrays.toString(patterns);
        if(args.length != 1){
            System.out.println(usage);
            System.exit(0);
        }
        List<String> possibles = Arrays.<String>asList(patterns);
        if(!possibles.contains(args[0])){
            System.out.println(usage);
            System.out.printf("(your parameter is : %s)\n", args[0]);
            System.exit(0);
        }

        switch(args[0]){
        	case "basic" :             test_basic(); break;
        	case "factorymethod" :    test_factorymethod(); break;
        	case "abstractfactory" :  test_abstractfactory(); break;
        	case "builder" :           test_builder(); break;
        	case "prototype" :         test_prototype(); break;
        }
    }
    
    // =========================================
    private static void test_basic(){
        var game = new maze.patterns.basic.MazeGame();
        Maze maze = game.createMaze();
        System.out.println(maze);
    }
    
    // =========================================
    private static void test_factorymethod(){
        Maze maze;
        
        // jeu standard
        var game1 = new maze.patterns.factorymethod.MazeGame();
        maze = game1.createMaze();
        System.out.println(maze);
        
        // jeu enchanted
        var game2 = new maze.patterns.factorymethod.EnchantedMazeGame();
        maze = game2.createMaze();
        System.out.println(maze);
        
        // jeu bombed
        var game3 = new maze.patterns.factorymethod.BombedMazeGame();
        maze = game3.createMaze();
        System.out.println(maze);
    }
    
    // =========================================
    private static void test_abstractfactory(){
        // dans ce pattern la fabrique abstraite est MazeGame
        var mazeGame = new maze.patterns.abstractfactory.MazeGame();
        Maze maze;
        
        // 1ere utilisation - jeu standard
        var factory1 = new maze.patterns.abstractfactory.MazeFactory();
        maze = mazeGame.createMaze(factory1);
        
        // 2e utilisation - enchanted
        var factory2 = new maze.patterns.abstractfactory.EnchantedMazeFactory();
        maze = mazeGame.createMaze(factory2);
        
        // 3e utilisation - bombed
        var factory3 = new maze.patterns.abstractfactory.BombedMazeFactory();
        maze = mazeGame.createMaze(factory3);
    }
    
    // =========================================
    private static void test_builder(){
        Maze maze;
        var gameDirector = new maze.patterns.builder.MazeGame();
        
        // jeu standard
        var builder1 = new maze.patterns.builder.StandardMazeBuilder();
        maze = gameDirector.createMaze(builder1);
        
        // jeu counting
        var builder2 = new maze.patterns.builder.CountingMazeBuilder();
        maze = gameDirector.createMaze(builder2);
        System.out.printf("%d rooms, %d doors\n", builder2.getRoomCount(), builder2.getDoorCount());
    }
    
    // =========================================
    private static void test_prototype(){
        var mazeGame = new maze.patterns.prototype.MazeGame();
        Maze maze;
        
        // 1ere utilisation - jeu standard
        var factory1 = new maze.patterns.prototype.MazePrototypeFactory();
        maze = mazeGame.createMaze(factory1);
        
        // 2e utilisation - enchanted
        var factory2 = new maze.patterns.prototype.EnchantedMazePrototypeFactory();
        maze = mazeGame.createMaze(factory2);
        
        // 3e utilisation - bombed
        var factory3 = new maze.patterns.prototype.BombedMazePrototypeFactory();
        maze = mazeGame.createMaze(factory3);
    }
}
