package commons;

import org.openqa.selenium.remote.server.handler.GoBack;

public class GlobalConsarts {
	public static final String DEV_SERVER = "";
	public static final String TESTING_SERVER = "";
	public static final String STAGING_SERVER = "";
	public static final long LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 5;
	public static final String ROOT_FOLDER = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String BROWSER_LOG_FOLDER = ROOT_FOLDER + getDirectirySlash("browerLog");
	public static final String DOWNLOAD_FOLDER = ROOT_FOLDER + getDirectirySlash("downloadFile");
	public static final String UPLOAD_FOLDER = ROOT_FOLDER + getDirectirySlash("uploadfile");
	//public static final String AUTOIT_FOLDER = ROOT_FOLDER + "\\";

	public static String getDirectirySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\" ;
		}
		return folderName;
	}

	public static boolean isWindown() {
		return (GlobalConsarts.OS_NAME.toLowerCase().indexOf("win") >= 0);

	}

	public static boolean isMac() {
		return (GlobalConsarts.OS_NAME.toLowerCase().indexOf("mac") >= 0);

	}

	public static boolean isUnix() {
		return (GlobalConsarts.OS_NAME.toLowerCase().indexOf("nix") >= 0
				|| GlobalConsarts.OS_NAME.toLowerCase().indexOf("nux") >= 0);

	}

	public static boolean isSolaris() {
		return (GlobalConsarts.OS_NAME.toLowerCase().indexOf("sunos") >= 0);

	}

}
