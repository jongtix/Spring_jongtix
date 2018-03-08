package com.jungang.teamPro.qnaboard;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "qnaBoardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class QnaBoardList {

	@XmlElement(name = "qnaBoard")
	private List<QnaBoard> qnaBoardList;

	public List<QnaBoard> getQnaBoardList() {
		return qnaBoardList;
	}

	public void setQnaBoardList(List<QnaBoard> qnaBoardList) {
		this.qnaBoardList = qnaBoardList;
	}

}
