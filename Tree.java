public class Tree {
    public Node TreeRoot;
    Node maximumTree=null;
    int counter;
    public int maximumTreeNodesAmount;
    public int amountOfNodesUnder,left,right;

    Tree(){
        TreeRoot=null;
        amountOfNodesUnder=0;
        left=0;
        right=0;
        counter=0;
        maximumTreeNodesAmount=0;
    }
public void func(){
}
//ghkghjkghjkghjk

    public void addLeaf(int number){
        if(TreeRoot==null){
            TreeRoot=new Node(number);
        }else{
            Node replace=TreeRoot;
            do{
                if(number<=replace.key){
                    if(replace.leftChild==null){
                        replace.leftChild=new Node(number);
                        break;
                    }else{
                        replace=replace.leftChild;
                    }
                }else{
                    if(replace.rightChild==null){
                        replace.rightChild=new Node(number);
                        break;
                    }else{
                        replace=replace.rightChild;
                    }
                }
            }
            while(true);

        }
    }

    private void outTreeHidden(Node root){
        if(root.leftChild!=null)
            outTreeHidden(root.leftChild);
        System.out.println(root.key);
        if(root.rightChild!=null)
            outTreeHidden(root.rightChild);
    }

    public void outTree(Node root){
        outTreeHidden(root);
    }

    public void amountOfNodes(Node root){
        if(root.leftChild!=null) {
            amountOfNodes(root.leftChild);
        }
        amountOfNodesUnder++;
        if(root.rightChild!=null){
            amountOfNodes(root.rightChild);
        }
    }

    public boolean leftMoreRight(Node root){
        if(root.leftChild!=null) {
            amountOfNodes(root.leftChild);
        }
        left=amountOfNodesUnder;
        amountOfNodesUnder=0;
        if (root.rightChild != null) {
            amountOfNodes(root.rightChild);
        }
        right=amountOfNodesUnder;
        amountOfNodesUnder=0;
        return left>=right;
    }
    public boolean leftMoreRightForAll(Node root){
        if(root==null){
            return true;
        }else {
            if (!leftMoreRight(root)) {
                return false;
            } else {
                if (leftMoreRightForAll(root.leftChild) && leftMoreRightForAll(root.rightChild)) {
                     return true;
                }else{
                    return false;
                }
            }
        }
    }


    public void overAll(Node root){
        if(root.leftChild!=null) {
            overAll(root.leftChild);
        }
        if(leftMoreRightForAll(root)){
            amountOfNodes(root);
            if(amountOfNodesUnder>maximumTreeNodesAmount){
                maximumTreeNodesAmount=amountOfNodesUnder;
                amountOfNodesUnder=0;
                maximumTree=root;
            }else{
                amountOfNodesUnder=0;
            }
        }
        if(root.rightChild!=null){
            overAll(root.rightChild);
        }
    }

   public class Inf{
        Node maxTree;
        int currentNode=0;
        int v=0;
   }

    public Node isMax(){
        Inf inf = new Inf();
        isMaxLeftMoreRight(this.TreeRoot,inf);
        return inf.maxTree;
    }

    public void isMaxLeftMoreRight(Node tr,Inf inf){
        if(tr==null){
            inf.currentNode=0;
            inf.maxTree=null;
        }else if(tr.leftChild==null && tr.rightChild==null){
            inf.maxTree=tr;
            inf.currentNode=1;
            inf.v=1;
        }else{
            Inf left = new Inf();
            Inf right = new Inf();
            isMaxLeftMoreRight(tr.leftChild,left); //если нет левого сына вернет null
            isMaxLeftMoreRight(tr.rightChild,right); //если нет правого сына вернет null
            if(left.maxTree==null){
                inf.maxTree=right.maxTree;
                inf.currentNode=right.currentNode;
            }else if(right.maxTree==null){
                if(left.v==1){
                    inf.maxTree=tr;
                    inf.currentNode= (left.currentNode+1);
                    inf.v=1;
                }else {
                    inf.maxTree = left.maxTree;
                    inf.currentNode = left.currentNode;
                }
            }else{
                if(left.v==1 && right.v==1){
                    if(left.currentNode>= right.currentNode){
                        inf.maxTree=tr;
                        inf.v=1;
                        inf.currentNode=(left.currentNode+ right.currentNode+1);
                    }
                }else{
                    if(left.currentNode>= right.currentNode){
                        inf.maxTree=left.maxTree;
                        inf.v=0;
                        inf.currentNode= left.currentNode;
                    }else{
                        inf.maxTree=right.maxTree;
                        inf.v=0;
                        inf.currentNode=right.currentNode;
                    }
                }
            }
        }

    }





}
