package leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dsx
 */
public class Tests {
    private long start;
    private long end;

    @Before
    public void start() {
        start = System.currentTimeMillis();
    }

    @After
    public void after() {
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println("耗时：" + (end - start) + "ms");
    }

    @Test
    public void HeapSort() {
        HeapSort heapSort = new HeapSort();
        int[] ints = {11, 21, 35, 15, 10, 9, 56};
        heapSort.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void shellSort() {
        ShellSort shellSort = new ShellSort();
        int[] ints = {11, 21, 35, 15, 10, 9, 56};
        shellSort.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    @Test
    public void test() {
        char ch = '哈';
        System.out.println(ch);

    }

    private String getString(String lv4Data, List<String> lv5Data) {
        Set<String> set = Arrays.stream(String.join(",", lv5Data).split(",")).collect(Collectors.toSet());
        return Arrays.stream(lv4Data.split(",")).filter(s -> !set.contains(s)).collect(Collectors.joining(","));
    }

    @Test
    public void solution90() {
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(new int[]{2,1,2,1,3}));
    }

    @Test
    public void solution89() {

        Solution89 solution89 = new Solution89();
        List<Integer> list = solution89.grayCode(2);
        System.out.println(list);
    }

    @Test
    public void solution88() {
        Solution88 solution88 = new Solution88();
        int[] ints = {0};
        solution88.merge(ints, 0, new int[]{1}, 1);

        print(ints);
    }

    public void print(int[] ints){
        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
        System.out.print("]");
    }


    @Test
    public void solution85() {
        Solution85 solution85 = new Solution85();
        char[][] chars = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int i = solution85.maximalRectangle(chars);
        System.out.println(i);
    }

    @Test
    public void solution84() {
        Solution84 solution84 = new Solution84();
        int i = solution84.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);
    }

    @Test
    public void solution82() {
        Solution82 solution82 = new Solution82();
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
//        ListNode listNode1 = solution82.deleteDuplicates(listNode);
        ListNode listNode = new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3)))));
        ListNode listNode1 = solution82.deleteDuplicates(listNode);
        System.out.println(listNode1);
    }

    @Test
    public void solution81() {
        Solution81 solution81 = new Solution81();
//        boolean search = solution81.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0);
//        System.out.println(search);
        System.out.println(solution81.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2));
    }

    @Test
    public void solution80() {
        Solution80 solution80 = new Solution80();

        int[] ints = new int[]{ 1,1,2,2,3};
        int len = solution80.removeDuplicates(ints);
        for (int i = 0; i < len; i++) {
            System.out.println(ints[i]);
        }
    }

    @Test
    public void solution79() {
        Solution79 solution79 = new Solution79();
        char[][] chars = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}

        };
        System.out.println(solution79.exist(chars,"ABCB"));

    }


    @Test
    public void solution78() {
        Solution78 solution78 = new Solution78();
        System.out.println(solution78.subsets(new int[]{1,2,2}));
    }



    @Test
    public void solution77() {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4,2));
    }

    @Test
    public void solution76() {
        Solution76 solution76 = new Solution76();
        String s = solution76.minWindow("AADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    @Test
    public void solution75() {
        Solution75 solution75 = new Solution75();
        int[] ints = new int[]{2, 0, 2, 1, 1, 0};
        solution75.sortColors(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    @Test
    public void solution74() {
        Solution74 solution74 = new Solution74();
        boolean b = solution74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);
        System.out.println(b);
    }

    @Test
    public void solution73() {
        Solution73 solution73 = new Solution73();
        int[][] ints = new int[][]{
                {1, 0, 2, 1},
                {3, 4, 5, 2},
                {0, 3, 1, 5}
        };
        solution73.setZeroes(ints);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void solution72() {
        Solution72 solution72 = new Solution72();
        int i = solution72.minDistance("horse", "ros");
        System.out.println(i);
    }

    @Test
    public void solution71() {
        Solution71 solution71 = new Solution71();
        System.out.println(solution71.simplifyPath("/../"));
    }

    @Test
    public void solution69() {
        Solution69 solution69 = new Solution69();
        System.out.println(solution69.mySqrt(2147483647));
    }

    @Test
    public void solution68() {
        Solution68 solution68 = new Solution68();
        System.out.println(solution68.fullJustify(new String[]{
            "Science","is","what","we","understand","well","enough","to","explain",
           "to","a","computer.","Art","is","everything","else","we","do"
        },20));
    }

    @Test
    public void solution67() {
        Solution67 solution67 = new Solution67();
        System.out.println(solution67.addBinary("1010", "1011"));
    }

    @Test
    public void solution66() {
        Solution66 solution66 = new Solution66();
        int[] ints = solution66.plusOne(new int[]{1, 2, 3});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    @Test
    public void solution65() {
        Solution65 solution65 = new Solution65();
        System.out.println(solution65.isNumber("95a54e53"));

    }

    @Test
    public void solution64() {
        Solution64 solution64 = new Solution64();
//        int i = solution64.minPathSum(new int[][]{
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        });
        int i = solution64.minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        System.out.println(i);
    }

    @Test
    public void solution63() {
        Solution63 solution63 = new Solution63();
        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}}));
        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{1, 0}}));

    }

    @Test
    public void solution62() {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(23, 12));
    }

    @Test
    public void solution61() {
        ListNode listNode = new ListNode(1);
        forAdd(listNode, 2, 5);
        System.out.println(listNode);
        Solution61 solution61 = new Solution61();
        ListNode listNode1 = solution61.rotateRight(listNode, 2);
        System.out.println(listNode1);
    }

    @Test
    public void solution60() {
        Solution60 solution60 = new Solution60();
        String permutation = solution60.getPermutation(4, 9);
        System.out.println(permutation);
    }

    @Test
    public void solution59() {
        Solution59 solution59 = new Solution59();
        int[][] ints = solution59.generateMatrix(4);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }


    @Test
    public void solution57() {
        Solution57 solution57 = new Solution57();
        int hello_world = solution57.lengthOfLastWord("hello world");
        System.out.println(hello_world);
    }

    @Test
    public void solution56() {
        Solution56 solution56 = new Solution56();
//        int[][] ints = new int[][]{
//                {1,3},{2,6},{8,10},{15,18}
//        };
        int[][] ints = new int[][]{
                {1,4},{4,5}
        };
        int[][] merge = solution56.merge(ints);
        for (int i = 0; i < merge.length; i++) {
            System.out.println("[" + merge[i][0] + "," + merge[i][1] + "]");
        }
    }

    @Test
    public void solution55() {
        Solution55 solution55 = new Solution55();
        boolean b = solution55.canJump(new int[]{3,2,1,0,4});
        System.out.println(b);
    }

    @Test
    public void solution54() {
        Solution54 solution54 = new Solution54();
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> list = solution54.spiralOrder(matrix);
        System.out.println(list);
    }

    @Test
    public void solution53() {
        System.out.println(new Solution53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void solution52() {
        Solution52 solution52 = new Solution52();
        System.out.println(solution52.totalNQueens(9));
    }

    @Test
    public void solution51() {
        Solution51 solution51 = new Solution51();
        List<List<String>> lists = solution51.solveNQueens(4);
        System.out.println(lists);
    }

    @Test
    public void solution50() {
        Solution50 solution50 = new Solution50();
        System.out.println(solution50.myPow(1, 2147483647));
    }

    @Test
    public void solution49(){
        Solution49 solution49 = new Solution49();
        List<List<String>> lists = solution49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    @Test
    public void solution48() {
        Solution48 solution48 = new Solution48();
        int[][] matrix = new int[][]{
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        solution48.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void solution47() {
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.permuteUnique(new int[]{2,2,1,1}));
    }

    @Test
    public void solution46() {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.permute(new int[]{1,2,3,4}));
    }

    @Test
    public void solution45() {
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.jump(new int[]{
                5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
//        System.out.println(solution45.jump(new int[]{
//                2,3,1,1,4}));
    }

    @Test
    public void solution44() {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.isMatch("abcabczzzde", "*abc???de*"));
    }

    @Test
    public void solution43() {
        int a = Integer.MAX_VALUE / 9;
        System.out.println(a);


        Solution43 solution43 = new Solution43();

        String s1 = "123456789";
        String s =  "987654321";
        //121932631112635269
        //121932631112635269
        //121932631112635269
        //12193263098917848
        //121932631112635269
        String multiply = solution43.multiply(s, s1);
        System.out.println(multiply);
    }

    @Test
    public void solution42() {
        Solution42 solution42 = new Solution42();
        int[] nums = new int[]{4,2,0,3,2,5};
        int i = solution42.trap(nums);
        System.out.println(i);
    }

    @Test
    public void solution41() {
        Solution41 solution41 = new Solution41();
        int[] nums = new int[]{7,8,9,11,12};
        int i = solution41.firstMissingPositive(nums);
        System.out.println(i);
    }

    @Test
    public void solution40() {
        Solution40 solution40 = new Solution40();
        int[] nums = new int[]{4,1,1,4,4,4,4,2,3,5};
        List<List<Integer>> lists = solution40.combinationSum2(nums, 10);
        System.out.println(lists);
    }


    @Test
    public void solution39() {
        Solution39 solution39 = new Solution39();
        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> lists = solution39.combinationSum(nums, 7);
        System.out.println(lists);
    }

    @Test
    public void solution38() {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(6));
    }

    @Test
    public void solution18() {
        Solution18 solution18 = new Solution18();
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        solution18.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void solution17() {
        Solution17 solution17 = new Solution17();
        char[][] board = new char[][]{
                {'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'},
        };
        boolean validSudoku = solution17.isValidSudoku(board);
        System.out.println(validSudoku);
    }

    @Test
    public void solution16() {
        Solution16 solution16 = new Solution16();
        int[] ints = solution16.searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println("[" + ints[0] + "," + ints[1] + "]");
    }

    @Test
    public void solution15() {
        Solution15 solution15 = new Solution15();
        int search = solution15.search(new int[]{1}, 0);
        System.out.println(search);
    }


    @Test
    public void solution14() {
        Solution14 solution14 = new Solution14();
//        int i = solution14.longestValidParentheses(")(((((()())()()))()(()))(");
        int i = solution14.longestValidParentheses("()(((()(()))))");
//        int i = solution14.longestValidParentheses("())(())");
        System.out.println(i);
    }

    @Test
    public void solution13() {
        Solution13 solution13 = new Solution13();
        int[] nums = new int[]{4,2,0,2,3,2,0};
        solution13.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    @Test
    public void solution12() {

        Solution12 solution12 = new Solution12();
        List<Integer> foob = solution12.findSubstring("ttqupktjvqeeylzkyirjnnjuhyrmrhwkaoepyzavshbquaasltdyimtpmmddtzotnsknsnkkumcooeizxmyfyrwlfbqyaetpzdetsodmahcpllqizopzhnmmodkqhdfijjbbxgqansryfhiewzgfmsscvcsfizntkpukvkkjfbjmkutitzoirgmpkfuughnrykbuwnfbqqqckjlgizqbhcqtjkosudlunookbvntodvymggwhyaodqkodygzbrtpfkbifodtszughcdpdffgvpwapdzrwtiefjomxsirrcyygdpjixrfmogctfvpafvfqksncchtgftmklysipxudfyynvoncjvsvpixrpsxumlexjyfbxbgdcfqzvfcgcuctczmtsjngxtdgtkjrnqwrxorsvvyaratwcgpurfaoyfxurgneylyvzrpwmowdqqzsyropwqewvbqojfvkqtfrkxowlmbdcdycumssdwoazhpkmkufdcwpzmnmzopdtngpcyhfwyfxhuhvecajexyfjlrkcioxywnauwfsumpbhwxnazzgwzlincurnioleblaysssejwngvdgucntdadqdxhqgwdmxonxghsmrqazldhfhuakvdbabksjgvvglkdtuxhlnhkymtgtogglmhnnrhwaetgrelkyjrlwbxxnqfjgnptzygmrpkrtezkklwiwqvursrgkyrrmgklgtaykmpgqpsacpkyhfsazmgkkadygnmnioltaczrtrtvigvpnqrncazoacpirbvapivpnwigpeeykzpxphmtjlkjnzrhaphrxeimartpxxphyheoqtjzetiuszbuokloowaqnvhkuzttgzjwssxxmftggubxeoluknkzjtldsgyygjwyctxqaqwhmzeqqrmcewepsrvkyvjgfhehbezbwxkjxqbphoromxfepappwavdhzkkflociynhpowycqmrnsveumtsmovwqhgxsuzdvmkkdjihzxyoruvlioevfbtvjzsdwugritblcltdkrtbnonydtvkwofhnzljvtceodrqrktbendtdstinosjczrsbedwzgcolugcgagmpliudbdqqvbuxumyyquawxqhtwmzwsondwiizlapibmfyyfyoaymzouulivjajzfhhnhunyeqkmojrnztnmuciopqkyqtxxbgkkczihrttiemxdgkpaoxpdnzefudcxkohmpsvjlqrpdoujykjpjaszbygycjvozfarxyakorbrhvchhowtorsqpyotjlhlskcricbwveqecsllgiexbwpsxfmgqttldvcnzgmwkcaowmafwecxdrpcwdkoxezczeqbkexwiyleknlgtnfwgwaealtzpuboytrkxphfnumxhxfanmztizykktjbpnsqgjagyhnldzkkzpnmdohmpfwcaidqvvidhilfszrvadibvxnynvkccjgftmxqhftqnhwfgpdislmnkzmxwybbjigcudsdkouxvqfdhinzvzphbdezdfanpirjnmnxcjxxbccimpjjraqsdwrhbuwtencsbrrdaocdqenewxnpzfhdbamfwkybxatbumewbjatnnylmlamrjrumfzkpxloagputwqufsnuiliwzkkswbmiimszlgolmfhhdabisrfcenzfzjxvnmfxayxlgnzssgayidibwnfbceicqizfufcwfzjlmidhrffzlpchdikhotlgbllxsotxncicnnletsdehinmsyugthnuuyrmomjeoridfthannguvvhntdvomkkhjbtzpfdgyljfgrftgnqbjzqecltqwdxhhtgwymcyzoegfjblxrogqekurflpjkwqdfodttcuhgamrezqxpyovlkoqvezgcrljgpcztxizzwsfvjdmhthsdvlbbmjeeunmjsnervdsryyohbaqwjlzgwaiijmogbcrtpwmmbffzdtggvzcgkbngexqplfvmhpizlulmztmeoukmtmsdohlugclrjhgsyorjkfvmajqogbazntfdcsxjwlcfuiasytbjayvaklpqmprckwfppfynqctklvcjofupfpppbgfpwzrivzxmexawavglqkwgprxwgnmjttbrssaqrxexvetvbbitleacvxzcmnnigozbjzrazvauctrdxzzkdbnzyodndqvjhwmqydsxbstdokilljvqkkrjauydntpwpbmnhemixfnnrxyehtvrgmcgjamyvbulegalkpvjwiwqiwupsrgyglgplsphtjuarwldnhnkrlcziwqcqzawkinvbcewnawezkhmtwwkkamuxcwpbylngylhcpgpsevrocfhbeuleghbkdsobdbjdmrhezwydtrswwbzavkfdriqwbezehikwbrcaqagjrahnbgozsvelduheaglipveqogteizobzxoceebwbgifcrjdyunprrhgzamjzckaaadehgciomnrgzwevjvnccvbdhkekufkwkqdqumhhzynawtwfojhsgkxnucxqjhotzsluesdfsqgolcvbncttmriivgagppbphmjnhmsbeyqrclsrqnkcgvnbbnhqeihlxsygethktxbwlvnbjafpvstyicqmnyykqyqxrxhlxljigylpaqhxlavtemfrkfbcgtzzthmqsvaywlqwdxuozpjddrvpwysesrelasduqdvmqlivkemjwvozmjrlijrcavpdquxgxsspdckphyyfungiyxvignkjkboavlgugalldybmwzrsozbnxyvfniqyleahsjdyjpjmnkyjmrcarfpqfnxtvotgutpmetmoiwcxidgwwkxnpofvbdqwtjfnewcjpozzmbwxgftdpsshhaciduhwdmljinuaetbqxanffjiubddidfrgbyeemrqwfkyjeabdcrihatdbwhmzodhqdnwpemljzmudmyiqpqxpjcsflegajnsmaqdhfrsednjrlrhchgttinaushwdwqszgvgnmyrrnaiyrrcbxvwgjwcdfagcqybywjmkhfcvgkvzcacbvyjgxljcnsefqheoqszaxbvfnshrsjtqkcwhqgjdaqjsxphojgoihlowfxoyihqslmbbunhudqnahuqqcgylrohxlxxweposbstyfasishkbdbrfhsqbiaauxzqeogwrarpfuipmpaovdhambtnkvpguoyyeewwhqlmkvcyneoihyivzdjjyarvppttwsrdidpuytslzhtiheegjpskpjfgzacxstacwrwxnrkmagvhkzpvohffrkmslopfhpigigfvzpibvdiheadshixavlsgzhljyvrhewcflmhhprotrtnzcnbxyufadsjcqalwynbjaksrcjnvccwgrydssksvddztfkrdasocdhthqiculzbezgwrroowtoraaifaaucfdymvirpvsqarzwiqnymiodjpnorniwvnuhieayasqajpythnstwgyfxnvpdglythhclicnaspmkofrbxnxgnefbaueghcbqldetfrwahikxnbanqyveeafgxloepqxatbwbssbbcnapobehzzlfcsmzdadsqaumdqnykozmbaerbiackljmfvnkyseotzcyrpwcfyoiyscbdcfpqodxmqikioadndchsyjawziwsmzxpemhvrehhmrpdrtsuxzpxiruizscmubdapkvgoendvegpzylwacuitqstkwhexmfmwcumhjpeoxtnyfmyjgidwdygzfnzrunpwibfrtkhsfvqkjowpzzncxvbeiaxcombypgriszdywtkfkgujfjnceqgnrfrhruhjbyttxwrtqcaciunqdaskqbxjgqsalzjoyehxbbttftvpqifviafadeklxclicwwcbfbeiuxpquficmdmolmtryfobswfrujsckykhvaxphftvkfkvtdnskbvdaauujowvmjcjlzasgtnrazmvfbnrfkufkqbvgarsjtduvdobyduyfhumkjdpuawgqycxavrjqxflavpzyjzdsvpffvubvrhlrjkrgecxbjkdebcenekfzbmgwhhrapdtanmhrqguzqyfuclhgvoixbotkylmpqfrftyzjgtkzrrtwcacaqmxrdsbbfnsxujdnkeyqziptzkpemtedgdulxyofngciphxznwqnghiisxoessjaxelwczdrfgzvpzufxmsdwclozzurtesskdrofufkchhuiezfqtimvwcuxzntfhlrnefszmebvmvdsuiiprxkpbemcufhbtaozfiyuncpbxttubdjuawlecygwfqaaqqayzasmchpcciygljcofosioagvqgyjxyhwabkdkzhnjfvuqxiwlcgzdmvvvtgutpstqcybdfqomliditbuvhvavqyslemeueamiapngfbuskzbfaxcjudhldzyjmfdqfsbfhonpqihchkhkjjteoarrapbouggbahhiwuzoegsotzycktizwzswrvmlesneawoysnozwgnpfntrgescdnawimiohxvhtlhnzvmxdzokohbxnubrhcnrqxizwdiropfpmrmptazhkdexxiqgkgzcfjccmmtdcysqshgljhutkbtjjjrvrtzxcdbpquuuvmknvsafawymztykfphwihvnmwectywomjdibfnddnsfhqpohxkseifqgjvzhtpvcudgbslhgdmptbdbyptezaxgjshsnxnqtryvjjcrnoiirnlqdewcgvkppshdpvvkotfzcjrrzbarpljushwydjosbxvsuqcijkiovbfvcfottznlgmljvbcwzxqvouezeopcpvxtcnnvmaisoucjvehwdxstsyvymkadfzwiolfaoovcixofdvcivwcpuxpghqjprhzgteihsdlcczifvmosisjerymaqvpieoqxtygncsqeramomcgwupanqmngjfontgnoftejlunfuzvidceztgmlucsfhiscphrwbvforsvnurvzvzzohlabnugucaztiqpjnuzgpvtlmokhpjxwvzxkvfhyfgrnyjyndatsvodjcqstzrpwtohotqmaygqwpoluqgnluswyiqtkiigbwpprhetfmjddaqxqwmeshasrrlbbvietzvkhbeonpsqpioghckzjmubfhcgdmmwoijxjplxedpuofavimwtasugazodnbbblkyuzktepjafqccyqbsqtoyvnnadqcebmfvorruiawoqyqrotlgnbfirujuknynbfkrwblhdhvuhnnxhaewbjgsdrmpencismzrqlytuvnekcbtcfreqywtrjiwymeqbfjrqhknearpcukfaclsahmrswpqlvjmbsdtcnigpzxsukzwmkootchmbxeounavgfrkuzqkbqexadvmnlciojurgbfdohaworgirzsupwrrbmfqxhznqvgzwncnucjiuqtnpnhgmyxnmcejjdzbafaxtckpftazltocgvisvhihjmsurrwrxwqqzahgwhhjcvmlswdnelwnzokqggkdeavfdelbmsmopabhxfwbssquhcmpkwupzpuetihhctysuzzrgwubqmvxpjoziiohxlntvucxpcpjcrckpynflifautbccqjbdywasbxhdpthixuxwhehqljkfkojcxmhvlhpmhwryrzgptflajusvfecpsnurbdomldaucsstrykmdvmorhlwnpogcizelosyrtuvlmrembqrxeiqntnbjbjnlitywmxqhrlugeyugqmfwuvkpinylwowghvdvuveniyvnyqtocylytxnekopicoolltjfonuzmqmkghbkhoialvgxlyhpmvdxpmefzyenosawzbggrojcmrbzpipddscueicfhivxbvwcyclprutfnuedevijnngtvibeqwcttyytcjivfdaszhxdcimqvsjqakvtizobxmubxexchxvgeulhcyzxqkotxjofkejjrfkokhttfoclknunntkggazdlpkvttemzpdlwwgdmirwyljlhwrpwssihcddykrzzukxssdgbwdbjomqmghjyztiewnciedhbphvhmckihlrxykkgrvetooxmbbvieejtleaxinhryzpylzecwlvkzuwdvrlbwuwjaxjlmqckrrjcspfoacaaxxduqqwmksymrhxdzcortztooaepffrccwwsmuhynfkgokknmaghbcvpcagjfzljvkdjgkhvrucfgovsqbbrdxii", new String[]{"wxnazzgwzlincurnioleblays","txwrtqcaciunqdaskqbxjgqsa","vdhzkkflociynhpowycqmrnsv","sondwiizlapibmfyyfyoaymzo","advmnlciojurgbfdohaworgir","gbwpprhetfmjddaqxqwmeshas","vmjcjlzasgtnrazmvfbnrfkuf","zjxvnmfxayxlgnzssgayidibw","xmsdwclozzurtesskdrofufkc","gglmhnnrhwaetgrelkyjrlwbx","galldybmwzrsozbnxyvfniqyl","ofrbxnxgnefbaueghcbqldetf","ltaczrtrtvigvpnqrncazoacp","psacpkyhfsazmgkkadygnmnio","mztmeoukmtmsdohlugclrjhgs","gjdaqjsxphojgoihlowfxoyih","gpcztxizzwsfvjdmhthsdvlbb","bksjgvvglkdtuxhlnhkymtgto","mewbjatnnylmlamrjrumfzkpx","orsqpyotjlhlskcricbwveqec","wsrdidpuytslzhtiheegjpskp","zehikwbrcaqagjrahnbgozsve","lzjoyehxbbttftvpqifviafad","phyyfungiyxvignkjkboavlgu","zdadsqaumdqnykozmbaerbiac","zxyoruvlioevfbtvjzsdwugri","xtvotgutpmetmoiwcxidgwwkx","cpvxtcnnvmaisoucjvehwdxst","jfgzacxstacwrwxnrkmagvhkz","nubrhcnrqxizwdiropfpmrmpt","rwahikxnbanqyveeafgxloepq","zncxvbeiaxcombypgriszdywt","ottznlgmljvbcwzxqvouezeop","rqguzqyfuclhgvoixbotkylmp","zdsvpffvubvrhlrjkrgecxbjk","kqbvgarsjtduvdobyduyfhumk","azhkdexxiqgkgzcfjccmmtdcy","igcudsdkouxvqfdhinzvzphbd","igylpaqhxlavtemfrkfbcgtzz","ezdfanpirjnmnxcjxxbccimpj","hwydjosbxvsuqcijkiovbfvcf","lzgwaiijmogbcrtpwmmbffzdt","fsqgolcvbncttmriivgagppbp","hsqbiaauxzqeogwrarpfuipmp","mxonxghsmrqazldhfhuakvdba","legajnsmaqdhfrsednjrlrhch","eebwbgifcrjdyunprrhgzamjz","suxzpxiruizscmubdapkvgoen","uvnekcbtcfreqywtrjiwymeqb","pquuuvmknvsafawymztykfphw","bhxfwbssquhcmpkwupzpuetih","pshdpvvkotfzcjrrzbarpljus","edgdulxyofngciphxznwqnghi","pwzrivzxmexawavglqkwgprxw","wimiohxvhtlhnzvmxdzokohbx","sjcqalwynbjaksrcjnvccwgry","qwfkyjeabdcrihatdbwhmzodh","thmqsvaywlqwdxuozpjddrvpw","jdpuawgqycxavrjqxflavpzyj","xphftvkfkvtdnskbvdaauujow","mwkcaowmafwecxdrpcwdkoxez","rrlbbvietzvkhbeonpsqpiogh","gyglgplsphtjuarwldnhnkrlc","sqshgljhutkbtjjjrvrtzxcdb","ihvnmwectywomjdibfnddnsfh","dymvirpvsqarzwiqnymiodjpn","evrocfhbeuleghbkdsobdbjdm","sbbfnsxujdnkeyqziptzkpemt","gmlucsfhiscphrwbvforsvnur","nfbceicqizfufcwfzjlmidhrf","tbqxanffjiubddidfrgbyeemr","fszmebvmvdsuiiprxkpbemcuf","ziwqcqzawkinvbcewnawezkhm","dmolmtryfobswfrujsckykhva","ewcflmhhprotrtnzcnbxyufad","qcebmfvorruiawoqyqrotlgnb","qdnwpemljzmudmyiqpqxpjcsf","xhaewbjgsdrmpencismzrqlyt","iyrrcbxvwgjwcdfagcqybywjm","rhezwydtrswwbzavkfdriqwbe","kljmfvnkyseotzcyrpwcfyoiy","xtygncsqeramomcgwupanqmng","uzoegsotzycktizwzswrvmles","fzlpchdikhotlgbllxsotxnci","rrwrxwqqzahgwhhjcvmlswdne","xtckpftazltocgvisvhihjmsu","aovdhambtnkvpguoyyeewwhql","qenewxnpzfhdbamfwkybxatbu","wqvursrgkyrrmgklgtaykmpgq","ezbwxkjxqbphoromxfepappwa","mzeqqrmcewepsrvkyvjgfhehb","ulzbezgwrroowtoraaifaaucf","rdxzzkdbnzyodndqvjhwmqyds","qtryvjjcrnoiirnlqdewcgvkp","slemeueamiapngfbuskzbfaxc","ssejwngvdgucntdadqdxhqgwd","lhgdmptbdbyptezaxgjshsnxn","qheoqszaxbvfnshrsjtqkcwhq","twwkkamuxcwpbylngylhcpgps","fszrvadibvxnynvkccjgftmxq","hftqnhwfgpdislmnkzmxwybbj","iimszlgolmfhhdabisrfcenzf","mztizykktjbpnsqgjagyhnldz","eacvxzcmnnigozbjzrazvauct","hkhkjjteoarrapbouggbahhiw","uknkzjtldsgyygjwyctxqaqwh","lduheaglipveqogteizobzxoc","ggvzcgkbngexqplfvmhpizlul","omjeoridfthannguvvhntdvom","uulivjajzfhhnhunyeqkmojrn","npofvbdqwtjfnewcjpozzmbwx","altzpuboytrkxphfnumxhxfan","scbdcfpqodxmqikioadndchsy","jfontgnoftejlunfuzvidcezt","pvohffrkmslopfhpigigfvzpi","kkhjbtzpfdgyljfgrftgnqbjz","sllgiexbwpsxfmgqttldvcnzg","exyfjlrkcioxywnauwfsumpbh","hkuzttgzjwssxxmftggubxeol","gftdpsshhaciduhwdmljinuae","uzktepjafqccyqbsqtoyvnnad","fnzrunpwibfrtkhsfvqkjowpz","gpvtlmokhpjxwvzxkvfhyfgrn","hgamrezqxpyovlkoqvezgcrlj","qslmbbunhudqnahuqqcgylroh","otchmbxeounavgfrkuzqkbqex","lcczifvmosisjerymaqvpieoq","ljvtceodrqrktbendtdstinos","jlkjnzrhaphrxeimartpxxphy","judhldzyjmfdqfsbfhonpqihc","lxrogqekurflpjkwqdfodttcu","firujuknynbfkrwblhdhvuhnn","cnnletsdehinmsyugthnuuyrm","stqcybdfqomliditbuvhvavqy","ckzjmubfhcgdmmwoijxjplxed","ttiemxdgkpaoxpdnzefudcxko","jiuqtnpnhgmyxnmcejjdzbafa","eumtsmovwqhgxsuzdvmkkdjih","irbvapivpnwigpeeykzpxphmt","czeqbkexwiyleknlgtnfwgwae","eklxclicwwcbfbeiuxpquficm","xatbwbssbbcnapobehzzlfcsm","ztnmuciopqkyqtxxbgkkczihr","heoqtjzetiuszbuokloowaqnv","vbdhkekufkwkqdqumhhzynawt","fjrqhknearpcukfaclsahmrsw","xlxxweposbstyfasishkbdbrf","qfrftyzjgtkzrrtwcacaqmxrd","ljcofosioagvqgyjxyhwabkdk","ecygwfqaaqqayzasmchpcciyg","lwnzokqggkdeavfdelbmsmopa","vzvzzohlabnugucaztiqpjnuz","hmpsvjlqrpdoujykjpjaszbyg","qecltqwdxhhtgwymcyzoegfjb","kkzpnmdohmpfwcaidqvvidhil","yorjkfvmajqogbazntfdcsxjw","ozmjrlijrcavpdquxgxsspdck","pbmnhemixfnnrxyehtvrgmcgj","hmjnhmsbeyqrclsrqnkcgvnbb","gnmjttbrssaqrxexvetvbbitl","mjeeunmjsnervdsryyohbaqwj","dbdqqvbuxumyyquawxqhtwmzw","pqlvjmbsdtcnigpzxsukzwmko","khfcvgkvzcacbvyjgxljcnsef","gttinaushwdwqszgvgnmyrrna","jawziwsmzxpemhvrehhmrpdrt","jraqsdwrhbuwtencsbrrdaocd","wcumhjpeoxtnyfmyjgidwdygz","zsupwrrbmfqxhznqvgzwncnuc","isxoessjaxelwczdrfgzvpzuf","mkvcyneoihyivzdjjyarvpptt","tblcltdkrtbnonydtvkwofhnz","bvdiheadshixavlsgzhljyvrh","wgyfxnvpdglythhclicnaspmk","jczrsbedwzgcolugcgagmpliu","hbtaozfiyuncpbxttubdjuawl","ysesrelasduqdvmqlivkemjwv","dvegpzylwacuitqstkwhexmfm","qpohxkseifqgjvzhtpvcudgbs","xnqfjgnptzygmrpkrtezkklwi","loagputwqufsnuiliwzkkswbm","qmaygqwpoluqgnluswyiqtkii","kfkgujfjnceqgnrfrhruhjbyt","hhuiezfqtimvwcuxzntfhlrne","fppfynqctklvcjofupfpppbgf","zhnjfvuqxiwlcgzdmvvvtgutp","wfojhsgkxnucxqjhotzsluesd","debcenekfzbmgwhhrapdtanmh","yjyndatsvodjcqstzrpwtohot","eahsjdyjpjmnkyjmrcarfpqfn","neawoysnozwgnpfntrgescdna","amyvbulegalkpvjwiwqiwupsr","orniwvnuhieayasqajpythnst","ckaaadehgciomnrgzwevjvncc","syvymkadfzwiolfaoovcixofd","dssksvddztfkrdasocdhthqic","vcivwcpuxpghqjprhzgteihsd","lcfuiasytbjayvaklpqmprckw","ycjvozfarxyakorbrhvchhowt","fpvstyicqmnyykqyqxrxhlxlj","puofavimwtasugazodnbbblky","nhqeihlxsygethktxbwlvnbja","xbstdokilljvqkkrjauydntpw"});
        System.out.println(foob);
    }

    @Test
    public void solution11() {
        Solution11 solution11 = new Solution11();
        System.out.println(3<<5);
        System.out.println(solution11.divide(100, 3));
    }

    @Test
    public void solution10() {
        Solution10 solution10 = new Solution10();
        int i = solution10.strStr("mississippi", "issip");
        System.out.println(i);
    }

    @Test
    public void solution9() {
        Solution9 solution9 = new Solution9();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int len = solution9.removeElement(nums,2);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    @Test
    public void solution8() {
        Solution8 solution8 = new Solution8();
        int[] nums = new int[]{1};
        int len = solution8.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    @Test
    public void solution7() {
        Solution7 solution7 = new Solution7();
        ListNode node = new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
//        ListNode listNode = solution7.reverseKGroup(no
        ListNode t = solution7.reverseKGroup(node,3);
        System.out.println(t);
    }

    @Test
    public void solution6() {
        Solution6 solution6 = new Solution6();
        ListNode listNode = solution6.swapPairs(new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))));
        System.out.println(listNode);
    }

    @Test
    public void solution5() {
        ListNode[] listNodes = new ListNode[]{
                new ListNode(1,new ListNode(4,new ListNode(5))),
                new ListNode(1,new ListNode(3,new ListNode(4))),
                new ListNode(2,new ListNode(6))
        };

        Solution5 solution5 = new Solution5();
        System.out.println(solution5.mergeKLists(listNodes));
    }

    @Test
    public void solution4() {

        Solution4 solution4 = new Solution4();
        List<String> abc = solution4.generateParenthesis(3);
        System.out.println(abc);
        System.out.println(abc.size());
    }

    @Test
    public void solution3() {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.isMatch("abc", "a*b*c*"));
    }

    @Test
    public void solution2() {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(listNode1);
        System.out.println(listNode2);

        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }


    @Test
    public void solution1() {
        System.out.println(new Solution1().isValid("{[]}"));
    }


    @Test
    public void solution() {
        ListNode listNode = new ListNode(1);
        forAdd(listNode, 2, 5);
        System.out.println(listNode);
        Solution solution = new Solution();
        ListNode listNode1 = solution.removeNthFromEnd(listNode, 5);
        System.out.println(listNode1);
    }

    public void forAdd(ListNode cur,int i,int len) {
        if (i <= len) {
            forAdd(cur.next = new ListNode(i), i + 1, len);
        }

    }
}
