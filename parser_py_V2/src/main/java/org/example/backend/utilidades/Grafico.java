package org.example.backend.utilidades;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author giovanic
 */
public class Grafico {

    public void writerDot(String str) {
        char[] tmp = str.trim().toCharArray();
//        String buffer = "graph { \n";
//        String bf1 = "\t";
//        for (int i = 0; i < tmp.length; i++) {
//            buffer += "\t{rank=same; " + tmp[i] + "}\n";
//            bf1 += (i < tmp.length - 1) ? "" + tmp[i] + " -- " : "" + tmp[i] + "\n";
//        }
//        buffer += "\n" + bf1 + " }";
        String bf = "";
        for (int i = 0; i < tmp.length; i++) {
            bf += (i < tmp.length - 1) ? "\"" + tmp[i] + "\" -> " : "\"" + tmp[i] + "\"";

        }
        String cadena = "digraph G {\n"
                + "    rankdir=\"LR\"\n"
                + "  subgraph cluster_0 {\n"
                + "    style=filled;\n"
                + "    color=lightgrey;\n"
                + "    node [style=filled,color=white];\n"
                + "    " + bf + ";\n"
                + "    \n"
                + "  }\n"
                + "}\n";
        FilesControl control = new FilesControl();
        control.writeFile(cadena, str);
    }

    public void entrada(String fileName) throws IOException {
        try {
            InputStream dot = new FileInputStream(new File("example/" + fileName + ".dot"));
            MutableGraph g = new Parser().read(dot);
            Graphviz.fromGraph(g).width(500).render(Format.PNG).toFile(new File("example/" + fileName + ".png"));
        } catch (IOException e) {
        }

//        try (InputStream dot = getClass().getResourceAsStream("/archive/archive.dot")) {
//            MutableGraph g = new Parser().read(dot);
//            //Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File("example/graph.png"));
//            Graphviz.fromGraph(g).width(300).render(Format.PNG).toFile(new File("example/graph.png"));
//            g.graphAttrs()
//                    .add(Color.WHITE.gradient(Color.rgb("888888")).background().angle(90))
//                    .nodeAttrs().add(Color.WHITE.fill())
//                    .nodes().forEach(node
//                            -> node.add(
//                            Color.named(node.name().toString()),
//                            Style.lineWidth(4), Style.FILLED));
//            Grafico.fromGraph(g).width(700).render(Format.PNG).toFile(new File("example/ex4-2.png"));
    }
}

