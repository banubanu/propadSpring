package com.prodapt.propad.model;

	import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "propad_emp_edu_details")
	public class PropadEmpEduDetails {
		
		@Id
		
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "ed_id")
		private int ed_id;
		private int ed_emp_id;
		private byte[] ed_edu_sslc;
		private String ed_edu_sslc_text;;
		private byte[] ed_edu_hsc;
		private String ed_edu_hsc_text;
		private byte[] ed_edu_dip;
		private String ed_edu_dip_text;
		private byte[] ed_edu_ug;
		private String ed_edu_ug_text;
		private byte[] ed_edu_pg;
		private String ed_edu_pg_text;
		private byte[] ed_edu_others;
		private String ed_edu_others_text;
		private String ed_edu_comments;
		
		
		public int getEd_id() {
			return ed_id;
		}

		public void setEd_id(int ed_id) {
			this.ed_id = ed_id;
		}

		public int getEd_emp_id() {
			return ed_emp_id;
		}

		public void setEd_emp_id(int ed_emp_id) {
			this.ed_emp_id = ed_emp_id;
		}

		public byte[] getEd_edu_sslc() {
			return ed_edu_sslc;
		}

		public void setEd_edu_sslc(byte[] bs) {
			this.ed_edu_sslc = bs;
		}

		public String getEd_edu_sslc_text() {
			return ed_edu_sslc_text;
		}

		public void setEd_edu_sslc_text(String ed_edu_sslc_text) {
			this.ed_edu_sslc_text = ed_edu_sslc_text;
		}

		public byte[] getEd_edu_hsc() {
			return ed_edu_hsc;
		}

		public void setEd_edu_hsc(byte[] bs) {
			this.ed_edu_hsc = bs;
		}

		public String getEd_edu_hsc_text() {
			return ed_edu_hsc_text;
		}

		public void setEd_edu_hsc_text(String ed_edu_hsc_text) {
			this.ed_edu_hsc_text = ed_edu_hsc_text;
		}

		public byte[] getEd_edu_dip() {
			return ed_edu_dip;
		}

		public void setEd_edu_dip(byte[] ed_edu_dip) {
			this.ed_edu_dip = ed_edu_dip;
		}

		public String getEd_edu_dip_text() {
			return ed_edu_dip_text;
		}

		public void setEd_edu_dip_text(String ed_edu_dip_text) {
			this.ed_edu_dip_text = ed_edu_dip_text;
		}

		public byte[] getEd_edu_ug() {
			return ed_edu_ug;
		}

		public void setEd_edu_ug(byte[] ed_edu_ug) {
			this.ed_edu_ug = ed_edu_ug;
		}

		public String getEd_edu_ug_text() {
			return ed_edu_ug_text;
		}

		public void setEd_edu_ug_text(String ed_edu_ug_text) {
			this.ed_edu_ug_text = ed_edu_ug_text;
		}

		public byte[] getEd_edu_pg() {
			return ed_edu_pg;
		}

		public void setEd_edu_pg(byte[] ed_edu_pg) {
			this.ed_edu_pg = ed_edu_pg;
		}

		public String getEd_edu_pg_text() {
			return ed_edu_pg_text;
		}

		public void setEd_edu_pg_text(String ed_edu_pg_text) {
			this.ed_edu_pg_text = ed_edu_pg_text;
		}

		public byte[] getEd_edu_others() {
			return ed_edu_others;
		}

		public void setEd_edu_others(byte[] ed_edu_others) {
			this.ed_edu_others = ed_edu_others;
		}

		public String getEd_edu_others_text() {
			return ed_edu_others_text;
		}

		public void setEd_edu_others_text(String ed_edu_others_text) {
			this.ed_edu_others_text = ed_edu_others_text;
		}

		public String getEd_edu_comments() {
			return ed_edu_comments;
		}

		public void setEd_edu_comments(String ed_edu_comments) {
			this.ed_edu_comments = ed_edu_comments;
		}

		@Override
		public String toString() {
			return "PropadEmpEduDetails [ed_id=" + ed_id + ", ed_emp_id=" + ed_emp_id + ", ed_edu_sslc="
					+ Arrays.toString(ed_edu_sslc) + ", ed_edu_sslc_text=" + ed_edu_sslc_text + ", ed_edu_hsc="
					+ Arrays.toString(ed_edu_hsc) + ", ed_edu_hsc_text=" + ed_edu_hsc_text + ", ed_edu_dip="
					+ Arrays.toString(ed_edu_dip) + ", ed_edu_dip_text=" + ed_edu_dip_text + ", ed_edu_ug="
					+ Arrays.toString(ed_edu_ug) + ", ed_edu_ug_text=" + ed_edu_ug_text + ", ed_edu_pg="
					+ Arrays.toString(ed_edu_pg) + ", ed_edu_pg_text=" + ed_edu_pg_text + ", ed_edu_others="
					+ Arrays.toString(ed_edu_others) + ", ed_edu_others_text=" + ed_edu_others_text
					+ ", ed_edu_comments=" + ed_edu_comments + "]";
		}

		


		
		}

		
		
	