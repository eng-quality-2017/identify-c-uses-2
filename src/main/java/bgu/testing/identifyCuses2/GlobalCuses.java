package bgu.testing.identifyCuses2;

import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtLocalVariableReference;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.ArrayList;
import java.util.List;


//no if and else
public class GlobalCuses {

    private static List<String> findCusesInMehod(CtMethod codeDomain) {
        List <String> globalCuse = new ArrayList<String>();
        List<CtStatement> statements = codeDomain.getBody().getStatements();
        List <String> list_Var = new ArrayList <String>();
        List <String> list_Use = new ArrayList <String>();

        for (CtStatement statement : statements) {
            //Integer currLine = statement.getPosition().getLine();

            if (statement instanceof CtAssignment) {
                CtAssignment assignment = (CtAssignment) statement;
                String defVar = assignment.getAssigned().toString();
                String compitiotn = assignment.getAssignment().toString();

                if (!(list_Var.contains(defVar)))
                    list_Var.add(defVar);

                if (!(list_Use.contains(compitiotn)))
                    list_Use.add(compitiotn);

            }
        }

//        System.out.println("all the defs");
//        for (String item : list_Var) {
//            System.out.println(item);
//        }
//
//        System.out.println("all the uses");
//        for (String item : list_Use) {
//            System.out.println(item);
//        }

        for (String var : list_Var) {
            for(String use: list_Use) {
                if(use.contains(var))
                    globalCuse.add(use);
            }
        }

        return globalCuse;
    }


    private int codeDomain(int x, int y) {
        int c, d, k;
        c = x + y;

        d = c - x / 2;
        k = x + d / 2;
        c = d+1;

        return k;
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.addInputResource("..\\identify-c-uses-2\\src\\main\\java\\bgu\\testing\\identifyCuses2\\GlobalCuses.java");
        launcher.getEnvironment().setAutoImports(true);
        launcher.getEnvironment().setNoClasspath(true);

        launcher.buildModel();
        CtModel model = launcher.getModel();
        List<CtMethod> methods = model.getElements(new TypeFilter<>(CtMethod.class));
        CtMethod codeDomain = methods.get(1);//get the second method in GlobalCuses class (codeDomain)
        List<String> cUses = findCusesInMehod(codeDomain);
        for (String use : cUses) {
            System.out.println(use);
        }
    }
}