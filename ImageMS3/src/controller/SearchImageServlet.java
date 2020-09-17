package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ImageDao;
import domain.Image;

/**
 * Servlet implementation class SearchImageServlet
 */
@WebServlet("/searchImage")
public class SearchImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/searchImage.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// エラーフラグ
//		boolean isError = false;
		// 画像名の取得
		String imageName = request.getParameter("imageName");
//		System.out.println(imageName);
		request.setAttribute("imageName", imageName);

		// 施設名の取得
		String facilityName = request.getParameter("facilityName");
		request.setAttribute("facilityName", facilityName);

		// 屋内外種別の取得
		Integer areaTypesId = Integer.parseInt(request.getParameter("areaTypesId"));
		request.setAttribute("areaTypesId", areaTypesId);
//		Integer areaTypesId = null;
//		String strAreaTypesId = request.getParameter("areaTypesId");
//		request.setAttribute("areaTypesId", strAreaTypesId);
//		if(strAreaTypesId != null && !strAreaTypesId.isEmpty()) {
//			try {
//				areaTypesId = Integer.parseInt(strAreaTypesId);
//			} catch (NumberFormatException e) {
//				request.setAttribute("areaTypesIdError", "屋内外を選択してください。");
//				isError = true;
//			}
//		}

		// エリア名の取得
		Integer areaNamesId = Integer.parseInt(request.getParameter("areaNamesId"));
		request.setAttribute("areaNamesId", areaNamesId);
//		Integer areaNamesId = null;
//		String strAreaNamesId = request.getParameter("areaNamesId");
//		request.setAttribute("areaNamesId", strAreaNamesId);
//		if(strAreaNamesId != null && !strAreaNamesId.isEmpty()) {
//			try {
//				areaNamesId = Integer.parseInt(strAreaNamesId);
//			} catch (NumberFormatException e) {
//				request.setAttribute("areaNamesIdError", "エリアを選択してください。");
//				isError = true;
//			}
//		}
//		System.out.println(imageName);
//		System.out.println(facilityName);
//		System.out.println(areaTypesId);
//		System.out.println(areaNamesId);
		// エラーがなければデータの追加
		// エラーがあればフォームの再表示
//		if(!isError) {
		// データの追加
		Image image = new Image();
		image.setImageName(imageName);
		image.setFacilityName(facilityName);
		image.setAreaTypesId(areaTypesId);
		image.setAreaNamesId(areaNamesId);
//		System.out.println(image.getImageName());
		try {
			ImageDao imageDao = DaoFactory.createImageDao();
			List<Image> imageList2 = imageDao.findPart(image);
			request.setAttribute("imageList2", imageList2);
			request.getRequestDispatcher("/WEB-INF/view/searchResultImage.jsp").forward(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		}

	}
//	}
}
