package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Image;

public class ImageDaoImpl implements ImageDao {

	private DataSource ds;

	public ImageDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Image> findAll() throws Exception {
		List<Image> imageList = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			String sql = "select *, area_types.name as type_name, area_names.name as area_name from (images "
					+ "join area_types on images.area_types_id = area_types.id)"
					+ "join area_names on images.area_names_id = area_names.id order by created desc";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				imageList.add(mapToImage(rs));
			}
		} catch(Exception e) {
			throw e;
		}
		return imageList;
	}

	@Override
	public List<Image> findPart(Image image) throws Exception {
	List<Image> imageList2 = new ArrayList<>();
	try(Connection con = ds.getConnection()){
		String sql = "select *, area_types.name as type_name, area_names.name as area_name from (images "
				+ "join area_types on images.area_types_id = area_types.id)"
				+ "join area_names on images.area_names_id = area_names.id ";
		// 以下、SearchImageServlet（doPost）でセットした値をget～で取得したい。
//		System.out.println(image.getImageName());
		
		//もし4項目のうち何か入力あったら、where句を＋する。
		// elseでバリデーションチェックしたほうがいいかも。
		if(!image.getImageName().equals("") || !image.getFacilityName().equals("")
				|| image.getAreaTypesId() != null || image.getAreaNamesId() != 0) {
			sql += "where ";
		}
		
		// 後からでいいけど、andをどう繋いでいくかも考えよう-ω-（image_nameなかったら、where and...になっちゃう
		if(!image.getImageName().equals("")) { // ←ここでぬるぽ発生（multipart/form-data入っとった><削除でok）
			sql += "image_name like ? ";
		}

		if(!image.getFacilityName().equals("")) {
			sql += "and facility_name like ? ";
		}

		if(image.getAreaTypesId() != null) {
			sql += "and area_types_id=? ";
		}

		if(image.getAreaNamesId() != 0) {
			sql += "and area_names_id=? ";
		}

		sql += "order by created desc";

		PreparedStatement stmt = con.prepareStatement(sql);
		// プレースホルダ（?パラメータ）にどういう値を格納するのか指定する。
		// 後からでいいけど、""とかnullとか0やったら?の数減るから、if文で囲うべきかな-ω-
		stmt.setString(1, image.getImageName());
		stmt.setString(2, image.getFacilityName());
		stmt.setObject(3, image.getAreaTypesId(), Types.INTEGER);
		stmt.setObject(4, image.getAreaNamesId(), Types.INTEGER);
//		System.out.println(image.getImageName());
//		System.out.println(image.getFacilityName());
//		System.out.println(image.getAreaTypesId());
//		System.out.println(image.getAreaNamesId());
// ↑ここまでは順調に値入ってる。
//		System.out.println(sql);
// ↑sql文も大丈夫っぽい。問題は次の文。$2の近くの構文確認しろって出るんよね、、←2個目、likeが抜けてた！解決！
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			imageList2.add(mapToImage(rs));
		}
	} catch(Exception e) {
		throw e;
	}
	return imageList2;
	}
	// できた・・・！歓喜TωT

	@Override
	public Image findById(Integer id) throws Exception {
		Image image = null;
		try(Connection con = ds.getConnection()){
			String sql ="select *, area_types.name as type_name, area_names.name as area_name from (images "
					+ "join area_types on images.area_types_id = area_types.id)"
					+ "join area_names on images.area_names_id = area_names.id where images.id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				image = mapToImage(rs);
			}
		} catch(Exception e) {
			throw e;
		}
		return image;
	}

	@Override
	public void insert(Image image) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql ="insert into images(image_name, facility_name, area_types_id, area_names_id, photo, memo, created) values(?, ?, ?, ?, ?, ?, now())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, image.getImageName());
			stmt.setString(2, image.getFacilityName());
			stmt.setObject(3, image.getAreaTypesId(), Types.INTEGER);
			stmt.setObject(4, image.getAreaNamesId(), Types.INTEGER);
			stmt.setString(5, image.getPhoto());
			stmt.setString(6, image.getMemo());
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Image image) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql ="update images set image_name=?, facility_name=?, area_types_id=?, area_names_id=?, photo=?, memo=? where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, image.getImageName());
			stmt.setString(2, image.getFacilityName());
			stmt.setObject(3, image.getAreaTypesId(), Types.INTEGER);
			stmt.setObject(4, image.getAreaNamesId(), Types.INTEGER);
			stmt.setString(5, image.getPhoto());
			stmt.setString(6, image.getMemo());
			stmt.setInt(7, image.getId());
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Image image) throws Exception {
		int id = image.getId();
		try(Connection con = ds.getConnection()){
			String sql ="delete from images where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		}

	}

	private Image mapToImage(ResultSet rs) throws Exception{
		Image image = new Image();
		image.setId((Integer)rs.getObject("id"));
		image.setImageName(rs.getString("image_name"));
		image.setFacilityName(rs.getString("facility_name"));
		image.setAreaTypesId((Integer)rs.getObject("area_types_id"));
		image.setAreaNamesId((Integer)rs.getObject("area_names_id"));
		image.setPhoto(rs.getString("photo"));
		image.setMemo(rs.getString("memo"));
		image.setCreated(rs.getTimestamp("created"));
		image.setTypeName(rs.getString("type_name"));
		image.setAreaName(rs.getString("area_name"));
		return image;
	}


}
