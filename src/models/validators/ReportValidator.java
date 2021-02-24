package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Report;

public class ReportValidator {
	public static List<String> validate(Report r) {
		List<String> errors = new ArrayList<String>();

		String title_error = _validateTitle(r.getTitle());
		if (!title_error.equals("")) {
			errors.add(title_error);
		}

		String content_error = _validateContent(r.getContent());
		if (!content_error.equals("")) {
			errors.add(content_error);
		}
		String start_time_error = _validateStart_time(r.getStart_time());
		if (!start_time_error.equals("")) {
			errors.add(start_time_error);
		}
		String end_time_error = _validateEnd_time(r.getEnd_time());
		if (!end_time_error.equals("")) {
			errors.add(end_time_error);
		}

		return errors;
	}

	private static String _validateTitle(String title) {
		if (title == null || title.equals("")) {
			return "タイトルを入力してください。";
		}

		return "";
	}

	private static String _validateContent(String content) {
		if (content == null || content.equals("")) {
			return "内容を入力してください。";
		}

		return "";
	}

	// 正規表現を使って選択できる時間を制限する。
	private static String _validateStart_time(String start_time) {
		if (!start_time.matches("^[0][6-9]:[0-5][0-9]$")) {
			return "出勤時間は６時から９時までを選択してください。";
		}

		return "";
	}

	private static String _validateEnd_time(String end_time) {
		if (!end_time.matches("^([1][8-9]|[2][0-1]):[0-5][0-9]$")) {
			return "退勤時間は18時から21時までを選択してください。";
		}
		return "";
	}
}
