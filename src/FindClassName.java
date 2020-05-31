import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.File;
import java.io.IOException;

public class FindClassName extends AnAction {

    public static final String javaPath = "src/main/java";
    public static final String classPath = "target/classes";

    @Override
    public void actionPerformed(AnActionEvent e) {
        VirtualFile virtualFile = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile();
        String path = virtualFile.getPath();
        String realClassPath = path.substring(0, path.lastIndexOf("/"));
        realClassPath = realClassPath.replaceAll(javaPath, classPath);
        try {
            java.awt.Desktop.getDesktop().open(new File(realClassPath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
