package com.algorithm.demo.tree_24;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树
 */
public class BinarySearchTree {
    Node root;

    public void insert(int data){
        if(root==null){
            root = new Node(data);
            return;
        }

        Node node = root;
        while(node!=null){
            if(data>node.value){
                if(node.right==null){
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            }else{
                if(node.left==null){
                    node.left=new Node(data);
                    return;
                }
                node = node.left;
            }
        }
    }


    public void delete(int data){
        Node p = root;
        Node pp = null;
        while(p!=null&&p.value!=data){
            pp = p;
            if(data>p.value){
                p = p.right;
            }else{
                p = p.left;
            }
        }

        if(p==null) return;

        if(p.left!=null&&p.right!=null){
            Node minP = p.right;
            Node minPP = p;
            while(minP.left!=null){
                minPP = minP;
                minP = minP.left;
            }
            p.value = minP.value;
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) root = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }


    /**
     * 根结点D、左子树L、右子树R
     * D=Degree
     * L=Left
     * R=Right
     */

    /**
     * 前序遍历
     */
    public void DLR(Node node){
        if(node==null) return;
        System.out.print(node.value+ ",");
        DLR(node.left);
        DLR(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void LDR(Node node){
        if(node==null) return;
        LDR(node.left);
        System.out.print(node.value+ ",");
        LDR(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    public void LRD(Node node){
        if(node==null) return;
        LRD(node.left);
        LRD(node.right);
        System.out.print(node.value+ ",");
    }

    /**
     * 层序遍历
     */
    public void FloorPrint() {
        Queue<Node> queue = new LinkedBlockingQueue();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value+",");
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(8);
        tree.insert(6);
        tree.insert(3);
        tree.insert(5);
        //tree.DLR(tree.root);
        //tree.LDR(tree.root);
        //tree.LRD(tree.root);
        tree.FloorPrint();
    }



    class Node{
        int value;
        Node left ;
        Node right;

        public Node(int data){
            this.value = data;
        }
    }
}
