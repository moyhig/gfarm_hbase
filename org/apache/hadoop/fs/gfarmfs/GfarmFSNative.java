package org.apache.hadoop.fs.gfarmfs;

import java.io.*;
import org.apache.hadoop.fs.FileStatus;

class GfarmFSNative {
    static {
        try {
            System.loadLibrary("GfarmFSNative");

            // TODO: calling init() in this timing is ok?
            int e = init();
            if(e != 0)
                throw new IOException(getErrorString(e));
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            System.err.println("Unable to load libGfarmFSNative library");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);            
        }
    }


    private final static native int init();
    private final static native int terminate();
    public final static native String getErrorString(int e);

    public final static native boolean exists(String path);   // Add 2013.03.12
    public final static native boolean isDirectory(String path);
    public final static native boolean isFile(String path);
    public final static native String[] readdir(String path);
// public FileStatus[] readdirplus(Path path) throws IOException;

    public final static native int mkdir(String path);
    public final static native int rename(String src, String dst);

    public final static native int rmdir(String path);
    public final static native int remove(String path);
// public long filesize(String path) throws IOException;
    public final static native long getReplication(String path);
// public short setReplication(String path, short replication) throws IOException;
    public final static native String[] getDataLocation(String path, long start, long len);

    public final static native long getModificationTime(String path);
// public FSDataOutputStream create(String path, short replication, int bufferSize, Progressable progress) throws IOException;
// public FSDataInputStream open(String path, int bufferSize) throws IOException;
// public FSDataOutputStream append(String path, int bufferSize, Progressable progress) throws IOException;

    public final static native long getFileSize(String path);

    public GfarmFSNative() throws IOException {
    }

    protected void finalize() throws Throwable {
        // TODO: Which timing should we call terminate?
        // terminate();
        super.finalize();
    }
}
