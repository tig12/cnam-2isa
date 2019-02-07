import java.io.File;
import java.net.URI;

class FileMethodsExamples{
    
    public static void main(String[] args){
        try{
            File f = new File("test.txt");
            
            // Gestion des droits
            boolean canX = f.canExecute();
            boolean canR = f.canRead();
            boolean canW = f.canWrite();
            boolean ok;
            ok = f.setReadOnly();
            ok = f.setExecutable(true);
            ok = f.setReadable(true);
            ok = f.setWritable(false);
            
            // Différents aspects du nom du fichier
            File absF = f.getAbsoluteFile();
            File canF = f.getCanonicalFile();
            String absName = f.getAbsolutePath();
            String canName = f.getCanonicalPath();
            String name = f.getName();
            String pName = f.getParent();
            URI fileURI = f.toURI(); // Create URI for File path
            
            // Metadata
            boolean exists = f.exists();
            boolean isAbs = f.isAbsolute();
            boolean isDir = f.isDirectory();
            boolean isFile = f.isFile();
            boolean isHidden = f.isHidden();
            long modTime = f.lastModified(); // milliseconds since epoch
            boolean updateOK = f.setLastModified(modTime); // milliseconds
            long fileLen = f.length();
            
            // Opérations sur le fichier
            boolean renamed = f.renameTo(new File("/new/filename"));
            boolean deleted = f.delete();
            boolean createdOK = f.createNewFile(); // n'écrase pas le fichier existant
            
            // Gestion de fichier temporaire
            File tmp = File.createTempFile("my-tmp", ".tmp");
            tmp.deleteOnExit();
            
            // Gestion de répertoire
            File dir = new File("/path/to/dir");
            boolean createdDir = dir.mkdir();
            String[] fileNames = dir.list();
            File[] files = dir.listFiles();
        }
        catch(Exception e){}
    }
    
}