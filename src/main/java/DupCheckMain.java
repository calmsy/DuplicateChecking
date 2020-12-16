
import utils.GetSimiarityUtil;
import utils.IOUtil;

import java.io.File;

public class DupCheckMain {


    public static void main(String[] args) {


        System.out.println("hello World");
        DupCheckMain d = new DupCheckMain();
        d.getRepetiveRate("src/main/orig.txt", "src/main/orig_0.8_add.txt");

    }


    /**
     * @param originalPath   原文件路径
     * @param plagiarizePath 抄袭文件路径
     * @return 返回结果
     */
    public double getRepetiveRate(String originalPath, String plagiarizePath) {
        Double result = null;
        File originalFile = new File(originalPath);
        File plagiarizeFile = new File(plagiarizePath);
        String oriStr = IOUtil.textToString(originalPath); //文本转为字符串
        String plagStr = IOUtil.textToString(plagiarizePath);
        if (!originalFile.exists() || !plagiarizeFile.exists()) {  //文件不存在
            return 0;
        }
        //余弦相似度计算
        GetSimiarityUtil getSimiarityUtil = new GetSimiarityUtil(oriStr, plagStr);
        System.out.println("相似度："+getSimiarityUtil.sim());
        result = getSimiarityUtil.sim();
        IOUtil.StringToFile("DuplicateChecking/src/main/result.txt", originalPath + "\n" + plagiarizePath + "\n"
                + "相似度 ：" + result);
        return result;
    }


}
