package com.shefin.stockwatch.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shefin.stockwatch.model.StockList;
import com.shefin.stockwatch.service.StockService;

import yahoofinance.Stock;

@Controller
public class homeController {
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping("/")
	public String getHome(Model model) {
		
		
		List<String> stockNames = Arrays.asList("IEFA","VIXY","UVXY","GOVT","UVIX","USHY","ARKG","EZU","VXX","SVXY","ITB","IGV","USMV","COWZ","INDA","CBOE","REM","EFV","SVIX","QUAL","DFIC","NOBL","HEFA","BBEU","IDV","VLUE","HYD","MTUM","ECH","FLOT","DIHP","IYZ","ITM","EFAV","BBJP","ACWV","DFIS","EEMV","ICSH","EFG","BBAX","MOAT","GOVZ","ITA","TSJA","PAVE","NUMV","VUSB","FGRO","SHYD","DISV","MLN","POCT","NEAR","BBCA","GSUS","IAGG","ARKX","IGE","OMFL","ESGV","JMST","VNM","NULV","ARKQ","ICF","CNYA","SLVP","IEO","AESR","AAAU","SYLD","EWUS","BBUS","TAIL","DALT","IBMM","DDLS","PTLC","IYT","DSEP","MSTB","XJR","TRTY","IFRA","LVHI","FNOV","GCOW","IQDG","NULG","CALF","XBOC","BUYW","ESML","ICVT","OILK","PICK","HYMU","OUSA","FBCG","BBRE","VSGX","REGL","SMIN","VFMF","XVV","IDME","DURA","FOCT","MFUL","EFAD","BUFT","PSMD","XSEP","IBMQ","PSMR","EMGF","TMFC","FCTR","PMAY","FJAN","DFNV","NUEM","ENOR","VOTE","IBHE","AFIF","NUSC","FAPR","PRNT","JEMA","PMAR","XTJL","IBMO","BOCT","DFND","USMF","GMOM","VXZ","PSMO","GVI","FLIA","CEFS","DAPR","GTIP","GEMD","IYJ","JMUB","IBHC","PSMJ","DUSA","BSEP","ROMO","PTMC","VIXM","GSEW","IGRO","BUFG","NOCT","DWLD","BALT","FCPI","FLQM","BBIN","EMHY","OUSM","VFVA","IBHB","FMIL","SMMD","VAMO","PSMM","CEMB","IBHD","RPHS","HEEM","TMAT","BUFR","NUDM","DIVB","FLQL","DMAY","SMDV","KNG","IPDP","DAUG","TDV","FJUL","NUMG","BJUL","JPIB","PSFD","SECT","PSFM","QVAL","TLTW","XDQQ","USEP","OGIG","MSVX","BJUN","PTEU","IVAL","FRDM","MEAR","PJUN","VFQY","GVAL","PTNQ","PSMG","IBML","WEED","EGIS","THY","BOSS","IBHG","PSCW","PAWZ","JCPB","PSFO","PFEB","PSFJ","DINT","SVAL","MOHR","FLDR","CSM","XMPT","JPHY","SMB","FDG","PDEC","TOKE","DFRA","DNOV","EFNL","FLBL","HSRT","PBTP","FBCV","PJAN","TFJL","EYLD","BMAR","OMFS","MPRO","FDRV","UAPR","ZECP","DFEB","ICOW","SMMV","PJUL","HEGD","HYHG","VCEB","GHYG","EPRF","GSID","FJUN","NURE","XTOC","IBMP","DDEC","PSCJ","QMOM","UMAR","QJUN","RULE","TMFM","IZRL","FLHY","MSTQ","FEDX","UAUG","IAUF","QSPT","LUXE","PSCX","PSEP","BUFF","BDEC","FMAY","FFEB","UJAN","TMDV","VMOT","FSMO","UFEB","FFTI","FFSG","PNOV","IGHG","BFEB","IBMN","BMAY","WFHY","FDEM","FCLD","EDEN","DMAR","UMAY","FDEC","TMFG","PSCQ","PAPR","QDEC","MRGR","HYBL","STLG","FYLD","LQDI","FPRO","ATMP","PSMB","HYXU","DDWM","KAPR","NETZ","PSMC","IBHF","ROCI","BJAN","BBSA","FPAG","JCPI","DOCT","MAMB","ADME","FRNW","XTAP","PAUG","EMTL","BAUG","NUDV","PSFF","UJUL","FDHT","ACIO","KJAN","IMOM","TYA","KOCT","HFGO","QLC","DRSK","TBJL","AMER","QTOC","HYDB","NJAN","HAUS","DJUL","FFTG","GAA","IEDI","XDSQ","FMAG","MRSK","OEUR","IETC","EWGS","FMAR","ESG","MOTI","XBJL","UJUN","FPFD","BLDG","VFMO","KJUL","RDFI","FSEP","WDNA","DJAN","BRLN","GDMN","PBDM","PBEE","BUFD","UOCT","JBBB","OSCV","TMFS","BLKC","PBUS","GLOV","ISVL","TILT","KWT","FFHG","NJUL","ESHY","SMOT","BUYZ","SPYI","NAPR","PBSM","IYLD","WUGI","FLV","BUFB","XDEC","XDOC","FAIL","TSLH","RSEE","VFMV","FDEV","IBHI","FIBR","EAOK","ESEB","SATO","FAUG","MBND","TTAI","HYIN","MAGA","DFHY","UDEC","XDAT","XSHD","FOMO","GLDB","SPMV","XBJA","JANZ","WLDR","BUFQ","BAPR","MOTG","XBTF","EAOR","DFNL","XJUN","PEX","GHTA","LYFE","FUNL","BNOV","EUDV","SFIG","LKOR","STOT","UNOV","LQDW","IGEB","DJUN","IDHD","YSEP","TTAC","JULZ","XSHQ","HELX","IVSG","EOPS","PUNK","LEAD","SEIM","VFLQ","XJH","QMAR","DWAT","RESD","XUSP","CVAR","RESE","ESGG","GDE","IVDG","PWS","IVLC","KNGS","BOB","ADFI","FLQS","GCLN","HSUN","IVRA","QTAP","ACSI","BGLD","EAOA","GSST","LIV","MBBB","XDJA","APXH","HCRB","IMLP","IQM","NULC","PBND","SHAG","APRZ","ARCM","AUGZ","CFCV","CLSE","DBJA","DBOC","DECZ","DSJA","DSOC","DUDE","DWCR","EAOM","EMCA","EMCH","EMDV","EMGC","EMPW","EMZA","ESCR","FEBZ","FLTN","GPAL","GSEE","HEET","HYGW","IBHH","IGLD","IMFL","IPPP","JUNZ","LCF","MAAX","MARZ","MAYZ","MBCC","MBNE","MDEV","MIG","MINN","MOTE","MSMR","NOVZ","OBND","OCTZ","PLRG","PLTL","PXUS","QCON","QPFF","QTJA","QTJL","REC","RODE","RODI","RSX","RSXJ","RTAI","SEIQ","SEIV","SELV","SEPZ","SMI","STLV","TSOC","TUSI","USEQ","VIRS","VMAT","VWID","WBAT","WFIG","WIL","WTAI","XBAP","XDAP","XDJL","XEMD","YDEC","YJUN","YMAR","YPS");
		model.addAttribute("stocks", stockNames);
		return "home-page.html";
	}
	
	@PostMapping("/display")
	public ModelAndView getDashboard(@ModelAttribute List<String> stocklist) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard.html");
		List<Stock> stocks= stockService.findStocks(stocklist);
		List<String> stockName = stocks.stream().map(stock->stock.getName()).collect(Collectors.toList());
//		List<BigDecimal> stockPrices = stockService.findp
		
		return mv;
	}

}
