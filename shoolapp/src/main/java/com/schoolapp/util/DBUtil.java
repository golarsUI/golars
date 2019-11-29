package com.schoolapp.util;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.schoolapp.bean.Alerts;
import com.schoolapp.bean.ChangePassword;
import com.schoolapp.bean.DeviceInformation;
import com.schoolapp.bean.Notification;
import com.schoolapp.bean.Settings;
import com.schoolapp.bean.User;
import com.schoolapp.bean.UserSettings;
import com.schoolapp.mail.MailUtil;

public class DBUtil {
	private static DBUtil dbObj;

	public DBUtil() {
	}

	public static DBUtil getInstance() {
		if (dbObj == null) {
			dbObj = new DBUtil();
		}
		return dbObj;
	}

	public User login(String username, String password) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, username);
			password = new String(Base64.getEncoder().encode(password.getBytes()));
			if (password.equals(user.getPassword())) {
				trx.commit();
				session.close();
				return user;
			}

		} catch (Exception exception) {
			System.out.println("Exception occred while login: " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}
		return null;
	}

	public User register(User userObj) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, userObj.getUsername());
			if (user != null)
				return null;
			userObj.setPassword(new String(Base64.getEncoder().encode(userObj.getPassword().getBytes())));
			session.save(userObj);
			trx.commit();
			session.close();
			return userObj;
		} catch (Exception exception) {
			System.out.println("Exception occred while register: " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		}
	}

	public User editUser(User userObj) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, userObj.getUsername());
			if (!userObj.getPassword().equals(user.getPassword()))
				userObj.setPassword(new String(Base64.getEncoder().encode(userObj.getPassword().getBytes())));
			// userObj.setNewlyCreated(user.isNewlyCreated());
			// boolean newleyCreated = user.isNewlyCreated();
			user.setFirstName(userObj.getFirstName());
			user.setLastName(userObj.getLastName());
			user.setActive(userObj.isActive());
			user.setAdmin(userObj.isAdmin());
			user.setEmailAddress(userObj.getEmailAddress());
			user.setPassword(userObj.getPassword());
			// user.setNewlyCreated(newleyCreated);
			session.update(user);
			String foldername = "";
			if (foldername.length() > 0) {
				if (foldername.endsWith(",")) {
					foldername = foldername.substring(0, foldername.lastIndexOf(","));
				}
				session.update(user);
			}
			trx.commit();
			session.close();
			return userObj;
		} catch (Exception exception) {
			System.out.println("Exception occred while update: " + exception.getMessage());
			exception.printStackTrace();
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		}
	}

	public boolean changePassword(ChangePassword changePasswordObj) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, changePasswordObj.getUsername());

			String password = new String(Base64.getEncoder().encode(changePasswordObj.getPassword().getBytes()));
			if (password.equals(user.getPassword())) {
				user.setPassword(
						new String(Base64.getEncoder().encode(changePasswordObj.getUpdatedPassword().getBytes())));
				user.setNewlyCreated(false);
				session.update(user);
				trx.commit();
				session.close();
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			System.out.println("Exception occred while changePassword: " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return false;
		}
	}

	public boolean resetPassword(ChangePassword changePasswordObj) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, changePasswordObj.getUsername());

			user.setPassword(new String(Base64.getEncoder().encode(changePasswordObj.getUpdatedPassword().getBytes())));
			session.update(user);
			trx.commit();
			session.close();
			return true;

		} catch (Exception exception) {
			System.out.println("Exception occred while changePassword: " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return false;
		}
	}

	public List<User> getAllUsers() {

		Session session = HibernateUtil.getSession();
		;
		Transaction t = session.beginTransaction();
		Query query = session.createNativeQuery("SELECT * FROM schooluser", User.class);
		List lst = query.list();
		session.close();
		return lst;
	}

	private String generateFileName(String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		fileName = fileName.replace(ext, gen() + ext);
		return fileName;
	}

	public int gen() {
		Random r = new Random(System.currentTimeMillis());
		return r.nextInt(200000);
	}

	/*
	 * private Notifications createDocFolder(Notifications folder, String
	 * docName, String documentProperties) { Notifications docFolder = new
	 * Notifications(); docFolder.setLabel(docName);
	 * docFolder.setParentid(folder.getParentid() + folder.getId()); if
	 * (!folder.getUsername().contains(folder.getUsername() + "&&&***&&&"))
	 * docFolder.setUsername(folder.getUsername() + "&&&***&&&");
	 * docFolder.setProperties(documentProperties); return docFolder; }
	 */

	public DeviceInformation retrieveDocument(int id, String filename) {

		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			// trx = session.beginTransaction();
			System.out.println("id-------" + id + " ---------" + filename);
			Query query = session.createNativeQuery("SELECT * FROM document d where d.name =:name and d.id =:folderId",
					DeviceInformation.class);
			query.setString("name", filename);
			query.setInteger("folderId", id);
			List list = query.list();
			System.out.println("list-------" + list);
			DeviceInformation doc = new DeviceInformation();
			if (list != null && list.size() > 0)
				doc = (DeviceInformation) list.get(0);
			trx.commit();
			session.close();
			return doc;
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Exception occred while retrieveDocument: " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}
	}

	public List<Alerts> retrieveAllFolders(String username, boolean isadmin) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		Query query = null;
		List<Alerts> lst = null;
		try {
			if (isadmin)
				query = session.createNativeQuery("SELECT * FROM folder f where f.isFolder=:isFolder order by name",
						Alerts.class);
			else {
				query = session.createNativeQuery(
						"SELECT * FROM folder f where f.isFolder=:isFolder and UPPER(userName) LIKE :userName or f.id=1000000 order by name",
						Alerts.class);
				query.setString("userName", "%" + username.toLowerCase() + "&&&***&&&%");
			}

			query.setBoolean("isFolder", true);
			lst = query.list();
			// if (!isadmin) {
			// for (Notifications folderObj : lst) {
			// if (folderObj.getId() != 1000000) {
			// List<Notifications> childList =
			// retrieveSpecificFolders(folderObj.getParentid() +
			// folderObj.getId(),
			// username, isadmin, false);
			// folderObj.setChildren(childList);
			// }
			// }
			// List<Notifications> tempList = new ArrayList<Notifications>();
			// for (Notifications folder : lst) {
			// getAllParents(lst, tempList, session, folder);
			//
			// }
			// lst.addAll(tempList);
			//
			// }

			trx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occred while retrieveAllFolders : " + e.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
		}
		return lst;
	}

	/*
	 * private void getAllParents(List<Notifications> lst, List<Notifications>
	 * tempList, Session session, Notifications folder) {
	 * 
	 * if (folder.getId() != 1000000 && checkExists(lst, folder.getParentid())
	 * == 0) { String parentid =
	 * folder.getParentid().substring(folder.getParentid().length() - 7); int
	 * pId = Integer.parseInt(parentid); Notifications flder = (Notifications)
	 * session.get(Notifications.class, pId); if (!lst.contains(flder) &&
	 * !tempList.contains(flder)) tempList.add(flder); if
	 * (folder.getParentid().equalsIgnoreCase("1000000")) return; else
	 * getAllParents(lst, tempList, session, flder);
	 * 
	 * } }
	 */

	/*
	 * private int checkExists(List<Notifications> lst, String parentid) {
	 * parentid = parentid.substring(parentid.length() - 7); int pId =
	 * Integer.parseInt(parentid); for (Notifications folder : lst) {
	 * 
	 * if (folder.getId() == pId) return pId; } return 0; }
	 */

	public List<Alerts> retrieveSpecificFolderWithParentIdAndName(String folderId) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		List lst = null;
		try {
			Query query = session.createNativeQuery("SELECT * FROM folder f where f.parentId = :parentId",
					Alerts.class);
			query.setString("parentId", folderId);
			lst = query.list();
			trx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occred while retrieveSpecificFolderWithParentIdAndName : " + e.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
		}
		return lst;
	}

	public List<Alerts> retrieveSpecificFolders(String folderId, String username, boolean isadmin,
			boolean docRequired) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		Query query = null;
		List lst = null;
		try {
			if (isadmin)
				query = session.createNativeQuery(
						"SELECT * FROM folder f where f.parentId = :parentId and f.isFolder=true", Alerts.class);
			else {
				query = session.createNativeQuery(
						"SELECT * FROM folder f where f.parentId = :parentId  and UPPER(userName) =:userName and f.isFolder=true",
						Alerts.class);
				query.setString("userName", username.toUpperCase());
			}
			query.setString("parentId", folderId);
			lst = query.list();
			trx.commit();
			session.close();

		} catch (Exception e) {
			System.out.println("Exception occred while retrieveSpecificFolders : " + e.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
		}
		return lst;
	}

	/*
	 * public String fetchDocDetails(String docName) { Session session =
	 * HibernateUtil.getSession(); ; Transaction t = session.beginTransaction();
	 * Query query = session.createNativeQuery(
	 * "SELECT details FROM document s where s.name=:filename");
	 * query.setString("filename", docName); List lst = query.list();
	 * session.close(); return (String) lst.get(0);
	 * 
	 * }
	 */

	public List<UserSettings> retrieveUserPreferences() {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		// query.setString("preferenceName", preferenceName);
		List lst = null;
		try {
			Query query = session.createNativeQuery("SELECT * FROM settings", UserSettings.class);
			lst = query.list();
			trx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occred while retrieveUserPreferences : " + e.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
		}
		// session.close();
		return lst;
	}

	public List<User> deleteUser(String username) {
		Session session = HibernateUtil.getSession();

		Transaction trx = session.beginTransaction();
		try {
			Query query = session.createNativeQuery("DELETE FROM schooluser WHERE userName =:username", Alerts.class);
			query.setString("username", username);
			int result = query.executeUpdate();
			trx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occred while deleting user : " + e.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
		}
		List<User> userList = getAllUsers();

		return userList;

	}

	public void updatePreferences(UserSettings[] settingArray) {
		Session session = null;

		Transaction trx = null;
		try {
			// stub
			for (UserSettings userPreObj : settingArray) {
				session = HibernateUtil.getSession();

				trx = session.beginTransaction();// TODO Auto-generated method
				UserSettings settings = (UserSettings) session.get(UserSettings.class, userPreObj.getKey());
				Query query = null;
				if (settings != null) {
					query = session.createNativeQuery("UPDATE settings s SET s.value =:value WHERE s.key =:key");
					query.setString("value", userPreObj.getValue());
					query.setString("key", userPreObj.getKey());
					int result = query.executeUpdate();
				} else {
					query = session.createSQLQuery("INSERT INTO  settings(`key`,`value`) values(?,?)  ");
					query.setParameter(0, userPreObj.getKey());
					query.setParameter(1, userPreObj.getValue());
					query.executeUpdate();
				}
				trx.commit();
				session.close();
			}
		} catch (Exception exception) {
			System.out.println("Exception occred while updating user Preferences : " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();

		}
		// User user = (User) session.get(User.class, username);

	}

	public List<Alerts> retrieveSearchResults(String searchString, String username, boolean isadmin) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		Query query = null;
		List<Alerts> lst = null;
		try {
			if (isadmin) {
				query = session.createNativeQuery(
						"SELECT * FROM folder f where f.isFolder=false and (f.details LIKE :details or f.name LIKE :name)",
						Alerts.class);
				query.setString("details", "%" + searchString + "%");
				query.setString("name", "%" + searchString + "%");
			} else {
				query = session.createNativeQuery(
						"SELECT id FROM folder f where f.isFolder=true and f.userName LIKE :username");
				query.setString("username", "%&&&***&&&" + username + "&&&***&&&%");
				List<Integer> idList = query.list();
				// constructing add condition
				String andCondition = "";
				System.out.println("idList ---" + idList.size());
				for (int i = 0; i < idList.size(); i++) {
					andCondition += "parentId like '%" + idList.get(i) + "%'";
					if (i < idList.size() - 1)
						andCondition += " or ";
				}

				String queryString = "SELECT * FROM folder f where f.isFolder=false and (f.details LIKE :details or f.name LIKE :name)";
				if (andCondition != null && andCondition.length() > 0)
					queryString += "and (" + andCondition + " )";

				query = session.createNativeQuery(queryString, Alerts.class);
				query.setString("details", "%" + searchString + "%");
				query.setString("name", "%" + searchString + "%");
			}

			// query.setBoolean("isFolder", true);
			lst = query.list();
			System.out.println("search result list size " + lst.size());
			// if (!isadmin) {
			// for (Folder folderObj : lst) {
			// if (folderObj.getId() != 1000000) {
			// List<Folder> childList =
			// retrieveSpecificFolders(folderObj.getParentid() +
			// folderObj.getId(),
			// username, true, false);
			// folderObj.setChildren(childList);
			// }
			// }
			// }
			trx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occred while retrieveAllFolders : " + e.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
		}
		return lst;
	}

	public User checkUserPresent(String emailAddress) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			;
			// Transaction t = session.beginTransaction();
			Query query = session.createNativeQuery("SELECT * FROM schooluser where emailAddress =:emailAddress",
					User.class);
			query.setString("emailAddress", emailAddress);
			List<User> lst = query.list();
			trx.commit();
			session.close();
			if (lst.size() == 1)
				return lst.get(0);
		} catch (Exception exception) {
			System.out.println("Exception occred while checkUserPresent for reset password: " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}
		return null;
	}

	public int updateDocumentProperties(String docId, String docName, String properties) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		Query query = null;
		int result = 0;
		try {
			query = session.createNativeQuery(
					"update folder f set f.details =:properties where f.parentId=:parentId and f.name =:name",
					Alerts.class);
			query.setString("properties", properties);
			query.setString("parentId", docId);
			query.setString("name", docName);

			result = query.executeUpdate();

			trx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occred while retrieveAllFolders : " + e.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
		}
		return result;
	}

	public Alerts getFolder(String path) {
		path = path.replace("\\", "/");
		String pathAarray[] = path.split("/");
		String parentId = "NULL";
		Alerts folder = null;
		for (String pathName : pathAarray) {
			folder = getFolderWithPath(pathName, parentId);
			if (parentId.equalsIgnoreCase("NULL"))
				parentId = folder.getId() + "";
			else
				parentId = parentId + folder.getId();
		}
		return folder;

	}

	private Alerts getFolderWithPath(String path, String parentId) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			Query query = null;
			List<Alerts> lst = null;
			query = session.createNativeQuery(
					"SELECT * FROM folder f where f.name =:path  and f.parentId LIKE :parentId", Alerts.class);
			query.setString("path", path);
			query.setString("parentId", parentId);
			lst = query.list();

			Alerts folder = lst.get(0);
			trx.commit();
			session.close();
			return folder;
		} catch (Exception exception) {
			System.out.println("Exception occred while getFolder: " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}

	}

	public User getUser(String username) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, username);

			trx.commit();
			session.close();
			return user;

		} catch (Exception exception) {
			System.out.println("Exception occred while login: " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}

	}

	public DeviceInformation retrieveDeviceInfo(String deviceId) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			DeviceInformation deviceInfo = (DeviceInformation) session.get(DeviceInformation.class, deviceId);
			if (deviceInfo != null)
				deviceInfo.setSettings(getSettings(false, session));
			deviceInfo.setServerKey(getServerKey());
			deviceInfo.setTestMode(getTestModeById("testMode",false,session));
			trx.commit();
			session.close();
			return deviceInfo;

		} catch (Exception exception) {
			System.out.println("Exception occred while retrieveDeviceInfo : " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}
	}

	public DeviceInformation saveOrUpdateDeviceInfo(DeviceInformation deviceInfo) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			DeviceInformation dbDeviceInfo = (DeviceInformation) session.get(DeviceInformation.class,
					deviceInfo.getDeviceId());
			if (dbDeviceInfo == null)
				session.save(deviceInfo);
			else {
				dbDeviceInfo.setCategories(deviceInfo.getCategories());
				dbDeviceInfo.setFcmToken(deviceInfo.getFcmToken());
				dbDeviceInfo.setPlatform(deviceInfo.getPlatform());
				session.update(dbDeviceInfo);
			}
			deviceInfo.setSettings(getSettings(false, session));
			deviceInfo.setServerKey(getServerKey());
			deviceInfo.setTestMode(getTestMode());	
			
			trx.commit();
			session.close();
			return deviceInfo;

		} catch (Exception exception) {
			System.out.println("Exception occred while saveOrUpdateDeviceInfo : " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}
	}

	public List<Alerts> retrieveAllAlerts(String deviceId) {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			DeviceInformation dbDeviceInfo = (DeviceInformation) session.get(DeviceInformation.class, deviceId);
			if (dbDeviceInfo != null) {
				String[] categoriesArray = dbDeviceInfo.getCategories().split(",");

				String categoryString = "";
				int counter = 0;
				if (categoriesArray.length > 0)
					categoryString += "where ";
				for (String category : categoriesArray) {
					if (counter != categoriesArray.length - 1)
						categoryString += "categories like '%" + category + "%' or ";
					else
						categoryString += "categories like '%" + category + "%' ";
					counter++;
				}
				categoryString += "order by createdon  desc limit 10";
				Query query = session.createNativeQuery("SELECT * FROM notifications " + categoryString, Alerts.class);
				List<Alerts> lst = query.list();
				return lst;

			}
			trx.commit();
			session.close();
			// Notifications notifications = constructNotifications();
			return null;

		} catch (Exception exception) {
			System.out.println("Exception occred while retrieveAllAlerts : " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}
	}

	public boolean sendNotifications(Notification notification) {

		String alertCol = getAlertInformation(notification);
		Alerts alert = new Alerts();
		alert.setCategories(alertCol);
		alert.setNotification(notification.getNotificationMessage());
		alert.setNotificationtitle(notification.getNotificationTitle());
		alert.setCreatedOn(new Date());
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			session.save(alert);
			trx.commit();
			session.close();

		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Exception occred while sendNotifications : " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return false;
		} finally {

		}

		return true;
	}

	private String getAlertInformation(Notification notification) {
		String alertcol = "";
		if (notification.isAdultFaith())
			alertcol += "adultFaith, ";
		if (notification.isChildFaith())
			alertcol += "childFaith, ";
		if (notification.isSilverAngle())
			alertcol += "silverAngle, ";
		if (notification.isSmgMen())
			alertcol += "smgMen, ";
		if (notification.isSmgNews())
			alertcol += "smgNews, ";
		if (notification.isSmgSchool())
			alertcol += "smgSchool, ";
		if (notification.isSmgSports())
			alertcol += "smgSports, ";
		if (notification.isSmgWomen())
			alertcol += "smgWomen, ";
		if (notification.isYoungFamily())
			alertcol += "youngFamily, ";
		if (notification.isYouthMin())
			alertcol += "youthMin, ";
		if (notification.isMusic())
			alertcol += "music, ";
		if (alertcol.endsWith(", "))
			alertcol = alertcol.substring(0, alertcol.lastIndexOf(", "));
		System.out.println("The selected categories are -----  " + alertcol);

		return alertcol;
	}

	public List<String> getDeviceIds(Notification notification, boolean isAndroid) {
		String alertCol = getAlertInformation(notification);
		String[] categoriesArray = alertCol.split(",");
		String mobileType = "";
		if (isAndroid)
			mobileType = "'%android%'";
		else
			mobileType = "'%ios%'";

		String categoryString = "";
		int counter = 0;
		categoryString += "where deviceType like " + mobileType;
		if (categoriesArray.length > 0)
			categoryString += " and (";
		for (String category : categoriesArray) {
			if (counter != categoriesArray.length - 1)
				categoryString += "categories like '%" + category.trim() + "%' or ";
			else
				categoryString += "categories like '%" + category.trim() + "%' )";
			counter++;
		}
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			Query query = session.createNativeQuery("SELECT fcmToken FROM deviceInfo " + categoryString);
			List<String> lst = query.list();
			trx.commit();
			session.close();
			return lst;
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Exception occred while getDeviceIds : " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return null;
		} finally {

		}
	}

	public boolean saveSettings(Settings[] settings) {

		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		try {
			for (Settings localSettings : settings) {
				
			
			Settings dbSettings = (Settings) session.get(Settings.class, localSettings.getId());
			if (dbSettings == null)
				session.save(localSettings);
			else {
				dbSettings.setValue(localSettings.getValue());
				session.update(dbSettings);
			}
			}
			trx.commit();
			session.close();
			return true;

		} catch (Exception exception) {
			System.out.println("Exception occred while saveSettings : " + exception.getMessage());
			if (trx != null)
				trx.rollback();
			if (session != null)
				session.close();
			return false;
		} finally {

		}

	}

	private static String getServerKey() {
		Properties emailProperties = new Properties();

		try {
			Class<DBUtil> cl = DBUtil.class;

			emailProperties.load(cl.getResourceAsStream("/emailconfig.properties"));
		} catch (Exception e1) {
			System.out.println("Configuration fiele not found" + e1.getMessage());
		}
		String AUTH_KEY_FCM = emailProperties.getProperty("AUTH_KEY_FCM");
		return AUTH_KEY_FCM;
	}

	private static String getTestMode() {
		Properties emailProperties = new Properties();

		try {
			Class<DBUtil> cl = DBUtil.class;

			emailProperties.load(cl.getResourceAsStream("/emailconfig.properties"));
		} catch (Exception e1) {
			System.out.println("Configuration fiele not found" + e1.getMessage());
		}
		String TESTMODE = emailProperties.getProperty("TESTMODE");
		if(TESTMODE == null)
			return false+"";
		return TESTMODE;
	}

	public static List getSettings(boolean alreadyInTransaction, Session session) {
		if (alreadyInTransaction) {
			Query query = session.createNativeQuery("SELECT * FROM settings", Settings.class);
			List lst = query.list();
			return lst;
		}
		session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		Query query = session.createNativeQuery("SELECT * FROM settings", Settings.class);
		List lst = query.list();
		t.commit();
		session.close();
		return lst;
	}

	public static String getTestModeById(String id, boolean alreadyInTransaction, Session session) {
		Settings settings = (Settings) session.get(Settings.class, id);
		if(settings != null)
		return settings.getValue();
			return false+"";
	}

}
