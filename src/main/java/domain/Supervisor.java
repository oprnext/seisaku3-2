package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

//Userテーブルのデータ格納用DTO
	@AllArgsConstructor
	@Data
	public class Supervisor {
		//フィールド名はカラム名と合わす
		//DB->スネークケース java->キャメルケース
		private Integer id;
		private String supervisorId;//login_id
		private String supervisorPass;//login_pass

	}

