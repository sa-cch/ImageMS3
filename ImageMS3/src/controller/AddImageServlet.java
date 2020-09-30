package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.ImageDao;
import domain.Image;

/**
 * Servlet implementation class AddImageServlet
 */
@WebServlet("/addImage")
@MultipartConfig(location = "C:/Users/zd1I14/temp")
public class AddImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addImage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// エラーフラグ
		boolean isError = false;

		// パラメータの取得
		// 画像名の取得とバリデーション
		String imageName = request.getParameter("imageName");
		request.setAttribute("imageName", imageName);
		if(imageName == null || imageName.isEmpty()) {
			request.setAttribute("imageNameError", "画像名が未入力です。");
			isError = true;
		}

		// 施設名の取得とバリデーション
		String facilityName = request.getParameter("facilityName");
		request.setAttribute("facilityName", facilityName);
		if(facilityName == null || facilityName.isEmpty()) {
			request.setAttribute("facilityNameError", "施設名が未入力です。");
			isError = true;
		}

		// 屋内外種別の取得
		// ラジオボタン未選択の場合にエラーとしたい。
//		Integer areaTypesId = Integer.parseInt(request.getParameter("areaTypesId"));
//		request.setAttribute("areaTypesId", areaTypesId);

		Integer areaTypesId = null;
		String strAreaTypesId = request.getParameter("areaTypesId");
		request.setAttribute("areaTypesId", strAreaTypesId);
		if(strAreaTypesId != null && !strAreaTypesId.isEmpty()) {
			try {
				areaTypesId = Integer.parseInt(strAreaTypesId);
			} catch (NumberFormatException e) {
				request.setAttribute("areaTypesIdError", "屋内外を選択してください。");
				isError = true;
			}
		}
		
		// エリア名の取得
		// テキストボックスではなくプルダウンにする。未選択の場合にエラーとしたい。
//		Integer areaNamesId = Integer.parseInt(request.getParameter("areaNamesId"));
//		request.setAttribute("areaNamesId", areaNamesId);
		
		Integer areaNamesId = null;
		String strAreaNamesId = request.getParameter("areaNamesId");
		request.setAttribute("areaNamesId", strAreaNamesId);
		if(strAreaNamesId != null && !strAreaNamesId.isEmpty()) {
			try {
				areaNamesId = Integer.parseInt(strAreaNamesId);
			} catch (NumberFormatException e) {
				request.setAttribute("areaNamesIdError", "エリアを選択してください。");
				isError = true;
			}
		}

		// 写真の取得
		// uploadsフォルダ内のファイルリストを取得する
		File uploadsDirectory = new File((request).getServletContext().getRealPath("/uploads"));
		// アップロードされたファイルを保存する
		Part part = request.getPart("photo");
		String filename = part.getSubmittedFileName();
		if(part.getSize() > 0) {
			part.write(uploadsDirectory + "/" + filename);
		}
		// ファイル名をリクエストスコープにセットする
		request.setAttribute("filename", filename);


		// メモの取得とバリデーション
		String memo = request.getParameter("memo");
		request.setAttribute("memo", memo);


		// エラーがなければデータの追加
		// エラーがあればフォームの再表示
		if(!isError) {
			// データの追加
			Image image = new Image();
			image.setImageName(imageName);
			image.setFacilityName(facilityName);
			image.setAreaTypesId(areaTypesId);
			image.setAreaNamesId(areaNamesId);
			image.setPhoto(filename);
			image.setMemo(memo);
			try {
				ImageDao imageDao = DaoFactory.createImageDao();
				imageDao.insert(image);
				request.getRequestDispatcher("/WEB-INF/view/addImageDone.jsp").forward(request, response);
			} catch(Exception e) {
				throw new ServletException(e);
			}

		} else {
			// フォームの再表示
			request.getRequestDispatcher("/WEB-INF/view/addImage.jsp").forward(request, response);
		}

	}

	}
