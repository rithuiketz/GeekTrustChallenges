package portifolioOverLap.util;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import portifolioOverLap.constants.AppConstants;
import portifolioOverLap.exceptions.InstrumentException.InstrumentAlreadyMappedException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundExistsException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundNotExistsException;
import portifolioOverLap.factory.MutalFundServiceFactory;
import portifolioOverLap.pojo.MutualFund;
import portifolioOverLap.pojo.Portifolio;
import portifolioOverLap.processor.CommandProcessor;
import portifolioOverLap.service.MutualFundService;

public class BasicCommandProcessor implements CommandProcessor {

	private static MutualFundService mfService = MutalFundServiceFactory
			.getMfService(MutalFundServiceFactory.EQUITY_MF_SERVICE_TYPE);

	private static final DecimalFormat decimalFormat = new DecimalFormat("#.00");

	@Override
	public void processCmd(String line, Portifolio portifolio) {
		if (StringUtils.isBlank(line))
			return;
		String[] cmdDetails = line.split(" ");

		switch (cmdDetails[0]) {
		case AppConstants.CURRENT_PORTFOLIO:
			handleCurrentPortifolio(line, portifolio);
			break;
		case AppConstants.ADD_STOCK:
			handleAddStock(line);
			break;
		case AppConstants.CALCULATE_OVERLAP:
			calculateOverlap(line, portifolio);
			break;
		case AppConstants.ADD_MF:
			createMutualFund(line);
			break;
		default:
			System.out.println("DEFAULT");
		}

	}

	@Override
	public void createMutualFund(String line) 
	{

		String[] cmdDetails = line.split(" ", 3);
		try {

			String mfName = cmdDetails[1];
			mfService.createMf(mfName);
			Optional<MutualFund> mf = mfService.getFundByName(mfName);
			if (mf.isPresent()) {

				String[] stocks = cmdDetails[2].split(";");
				for (String stock : stocks) {
					mfService.addInstrument(mfName, stock);
				}

			}
		} catch (MutualFundExistsException | InstrumentAlreadyMappedException | MutualFundNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public  void calculateOverlap(String line, Portifolio portifolio) {
		String[] cmdDetails = line.split(" ");
		String mfTobeChecked = cmdDetails[1];
		Optional<MutualFund> fundTobeChecked = mfService.getFundByName(mfTobeChecked);
		if (!fundTobeChecked.isPresent()) {
			System.out.println(AppConstants.FUND_NOT_FOUND);
			return;
		}

		Collection<MutualFund> mutualFunds = portifolio.getMutualFunds();
		mutualFunds.forEach(mf -> {
			try {
				double overLap = mfService.calculateOverLap(mfTobeChecked, mf.getName());
				if (overLap > 0) {
					System.out.println(mfTobeChecked + " " + mf.getName() + " " + decimalFormat.format(overLap) + "%");
				}

			} catch (MutualFundNotExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

	@Override
	public  void handleAddStock(String line) {
		String[] cmdDetails = line.split(" ", 3);
		String mfTobeChecked = cmdDetails[1];
		Optional<MutualFund> fundTobeChecked = mfService.getFundByName(mfTobeChecked);
		if (!fundTobeChecked.isPresent()) {
			System.out.println(AppConstants.FUND_NOT_FOUND);
			return;
		}
		try {
			mfService.addInstrument(mfTobeChecked, cmdDetails[2]);
		} catch (InstrumentAlreadyMappedException | MutualFundNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public  void handleCurrentPortifolio(String line, Portifolio portifolio) {
		String[] cmdDetails = line.split(" ");

		for (int i = 1; i < cmdDetails.length; i++) {
			String mfName = cmdDetails[i];
			Optional<MutualFund> mf = mfService.getFundByName(mfName);
			if (!mf.isPresent()) {
				System.out.println("FUND_NOT_FOUND");
			} else {
				portifolio.addAddMfToPortifolio(mf.get());
			}
		}

	}

}
