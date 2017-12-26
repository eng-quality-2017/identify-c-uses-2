package bgu.testing.identifyCuses2;

import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.ArrayList;
import java.util.List;


//no if and else
public class GlobalCuses {

    public static List<String> findCUsesInMethod(String path, String varible) {
        CtModel model = createCodeModel(path);

        List<CtMethod> methods = model.getElements(new TypeFilter<>(CtMethod.class));
        CtMethod codeDomain = methods.get(0);


        List<String> globalCuse = new ArrayList<String>();
        List<CtStatement> statements = codeDomain.getBody().getStatements();
        List<String> list_Var = new ArrayList<String>();
        List<String> list_Use = new ArrayList<String>();

        for (CtStatement statement : statements) {
            if(statement instanceof CtAssignment) {
                CtAssignment assignment = (CtAssignment) statement;
                String defVar = assignment.getAssigned().toString();
                String compitiotn = assignment.getAssignment().toString();

                if(!(list_Var.contains(defVar))) list_Var.add(defVar);
                if(!(list_Use.contains(compitiotn))) list_Use.add(compitiotn);
            }
        }
        if (!(list_Var.contains(varible)))
            return globalCuse; //return empty list no def for input varible
//        for (String var : list_Var) {
            for (String use : list_Use) {
                if(use.contains(varible)) globalCuse.add(use);
        }

        for (String use : globalCuse) {
            System.out.println(use);
        }

        return globalCuse;
    }

    private static CtModel createCodeModel(String path) {
        Launcher launcher = new Launcher();
        launcher.addInputResource(path);
        launcher.getEnvironment().setAutoImports(true);
        launcher.getEnvironment().setNoClasspath(true);

        launcher.buildModel();
        return launcher.getModel();
    }
}