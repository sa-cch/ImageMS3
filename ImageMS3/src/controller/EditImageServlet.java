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
 * Servlet implementation class EditImageServlet
 */
@WebServlet("/editImage")
@MultipartConfig(location = "C:/Users/zd1I14/temp")
public class EditImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String strId = request.getParameter("id");
			Integer id = Integer.parseInt(strId);
			ImageDao imageDao = DaoFactory.createImageDao();
			Image image = imageDao.findById(id);
			request.setAttribute("imageName", image.getImageName());
			request.setAttribute("facilityName", image.getFacilityName());
			request.setAttribute("areaTypesId", image.getAreaTypesId());
			request.setAttribute("areaNamesId", image.getAreaNamesId());
			request.setAttribute("photo", image.getPhoto());
			request.setAttribute("memo", image.getMemo());
			request.getRequestDispatcher("/WEB-INF/view/editImage.jsp").forward(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		}
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
		// TODO ラジオボタン未選択の場合にエラーとしたい。
		Integer areaTypesId = Integer.parseInt(request.getParameter("areaTypesId"));
		request.setAttribute("areaTypesId", areaTypesId);

		// エリア名の取得とバリデーション
		// TODO テキストボックスではなくプルダウンにする。未選択の場合にエラーとしたい。
		Integer areaNamesId = Integer.parseInt(request.getParameter("areaNamesId"));
		request.setAttribute("areaNamesId", areaNamesId);


		// 写真の取得とバリデーション
		File uploadsDirectory = new File(request.getServletContext().getRealPath("/uploads"));
		// アップロードされたファイルを保存する
		Part part = request.getPart("photo");
		String filename = part.getSubmittedFileName();
		if(part.getSize() > 0) {
			part.write(uploadsDirectory + "/" + filename);
		}
		// ファイル名をリクエストスコープにセットする
		request.setAttribute("filename", filename);


		// メモの取得
		String memo = request.getParameter("memo");
		request.setAttribute("memo", memo);


		// エラーがなければデータの追加
		// エラーがあればフォームの再表示
		if(!isError) {
			// データの更新
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				ImageDao imageDao = DaoFactory.createImageDao();
				Image image = imageDao.findById(id);
				image.setImageName(imageName);
				image.setFacilityName(facilityName);
				image.setAreaTypesId(areaTypesId);
				image.setAreaNamesId(areaNamesId);
				image.setPhoto(filename);
				image.setMemo(memo);
				imageDao.update(image);
				request.getRequestDispatcher("/WEB-INF/view/editImageDone.jsp").forward(request, response);
			} catch(Exception e) {
				throw new ServletException(e);
			}
		} else {
			// フォームの再表示
			request.getRequestDispatcher("/WEB-INF/view/editImage.jsp").forward(request, response);
		}
	}

}

