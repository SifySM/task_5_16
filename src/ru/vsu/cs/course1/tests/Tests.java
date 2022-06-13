package ru.vsu.cs.course1.tests;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.vsu.cs.course1.tree.MySimpleBinaryTree;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public final class Tests {

    @Parameterized.Parameter
    public @NotNull TestCase testCase;

    @Parameterized.Parameters
    public static @NotNull
    Collection<TestCase> data(){
        List<TestCase> resList = Arrays.asList(
                new TestCase (6, "0 (1 (2 (3 (4 (5 (6, 6), 5 (6, 6)), 4 (5 (6, 6), 5 (6, 6))), 3 (4 (5 (6, 6), 5 (6, 6)), 4 (5 (6, 6), 5 (6, 6)))), 2 (3 (4 (5 (6, 6), 5 (6, 6)), 4 (5 (6, 6), 5 (6, 6))), 3 (4 (5 (6, 6), 5 (6, 6)), 4 (5 (6, 6), 5 (6, 6))))), 1 (2 (3 (4 (5 (6, 6), 5 (6, 6)), 4 (5 (6, 6), 5 (6, 6))), 3 (4 (5 (6, 6), 5 (6, 6)), 4 (5 (6, 6), 5 (6, 6)))), 2 (3 (4 (5 (6, 6), 5 (6, 6)), 4 (5 (6, 6), 5 (6, 6))), 3 (4 (5 (6, 6), 5 (6, 6)), 4 (5 (6, 6), 5 (6, 6))))))"),
                new TestCase (2, "0 (1 (2, 2), 1 (2, 2))"),
                new TestCase (-1, null)
        );
        return resList;
    }

    public static final class TestCase {
        public final int NLevel;
        public final String treeStr;

        public TestCase(int NLevel, String treeStr) {
            this.NLevel = NLevel;
            this.treeStr = treeStr;
        }
    }

    @Test
    public void test() {
        MySimpleBinaryTree tree = new MySimpleBinaryTree();
        tree.makeNLevelTree(testCase.NLevel);

        Assert.assertEquals(tree.toBracketStr(), testCase.treeStr);
    }
}

