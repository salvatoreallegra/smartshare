package com.ftd.smartshare.client.api;

import com.ftd.smartshare.client.dto.DownloadRequestDto;
import com.ftd.smartshare.client.dto.UploadRequestDto;
import com.ftd.smartshare.utils.NotImplementedException;

import java.io.IOException;
import java.net.Socket;

public final class Api {

    private static final String HOST    = "localhost";
    private static final int    PORT    = 3000;

    private Api () {
        throw new UnsupportedOperationException();
    }

    /**
     * Send download request
     *
     * @param downloadRequestDto    JAXB annotated class representing the download request
     * @return true if request was successful and false if unsuccessful
     */
    public static boolean download(DownloadRequestDto downloadRequestDto) {
        try (Socket socket = new Socket(HOST, PORT)) {
            // TODO
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NotImplementedException();
    }

    /**
     *
     * @param uploadRequestDto      JAXB annotated class representing the upload request
     * @return
     */
    public static boolean upload(UploadRequestDto uploadRequestDto) {
        try (Socket socket = new Socket(HOST, PORT)) {
            // TODO
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NotImplementedException();
    }

}
