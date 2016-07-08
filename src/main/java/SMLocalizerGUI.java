/* Copyright 2016 Kristoffer Bernhem.
 * This file is part of SMLocalizer.
 *
 *  SMLocalizer is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SMLocalizer is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with SMLocalizer.  If not, see <http://www.gnu.org/licenses/>.
 */

@SuppressWarnings("serial")
public class SMLocalizerGUI extends javax.swing.JFrame {

	/**
	 * Creates new form NewJFrame
	 */
	public SMLocalizerGUI() {
		initComponents();
	}
 
    private void initComponents() {

        basicSettingsLabel = new javax.swing.JLabel();
        advancedSettingsLabel = new javax.swing.JLabel();
        pixelSizeLabel = new javax.swing.JLabel();
        pixelSize = new javax.swing.JTextField();
        outpPixelSize = new javax.swing.JLabel();
        desiredPixelSize = new javax.swing.JTextField();
        medianWindowLabel = new javax.swing.JLabel();
        medianWindow = new javax.swing.JTextField();
        gWindowLabel = new javax.swing.JLabel();
        gWindow = new javax.swing.JComboBox<>();
        positivePixelsLabel = new javax.swing.JLabel();
        positivePixels = new javax.swing.JTextField();
        MinSignal_Label = new javax.swing.JLabel();
        MinSignal = new javax.swing.JTextField();
        Chi_low = new javax.swing.JTextField();
        Chi_high = new javax.swing.JTextField();
        xyDriftLabel = new javax.swing.JLabel();
        zDriftLabel = new javax.swing.JLabel();
        xyDrift = new javax.swing.JTextField();
        zDrift = new javax.swing.JTextField();
        Process = new javax.swing.JButton();
        correctBackground = new javax.swing.JButton();
        localize = new javax.swing.JButton();
        driftCorrect = new javax.swing.JButton();
        ClusterAnalysis = new javax.swing.JButton();
        render = new javax.swing.JButton();
        cleanTable = new javax.swing.JButton();
        MinPartDistLabel = new javax.swing.JLabel();
        lowPhotonCount = new javax.swing.JTextField();
        highPhotonCount = new javax.swing.JTextField();
        lowSigma = new javax.swing.JTextField();
        highSigma = new javax.swing.JTextField();
        headerSelect = new javax.swing.JLabel();
        lowSigmaZ = new javax.swing.JTextField();
        highSigmaZ = new javax.swing.JTextField();
        lowPrecisionXY = new javax.swing.JTextField();
        highPrecisionXY = new javax.swing.JTextField();
        minPartClabel = new javax.swing.JLabel();
        driftLabel = new javax.swing.JLabel();
        lowDriftBinCount = new javax.swing.JTextField();
        highDriftBinCount = new javax.swing.JTextField();
        stepSizeLabe = new javax.swing.JLabel();
        stepsizeXY = new javax.swing.JTextField();
        stepsizeZ = new javax.swing.JTextField();
        epsilonLabel = new javax.swing.JLabel();
        epsilon = new javax.swing.JTextField();
        MinPtsLabel = new javax.swing.JLabel();
        minPts = new javax.swing.JTextField();
        doClusterAnalysis = new javax.swing.JCheckBox();
        binCountLabel = new javax.swing.JLabel();
        binCount = new javax.swing.JTextField();
        screenLabel = new javax.swing.JLabel();
        inclPhotonCount = new javax.swing.JCheckBox();
        inclXYsigma = new javax.swing.JCheckBox();
        inclZsigma = new javax.swing.JCheckBox();
        inclChiSquare = new javax.swing.JCheckBox();
        inclXYprecision = new javax.swing.JCheckBox();
        minParticleDistance = new javax.swing.JTextField();
        inclZprecision = new javax.swing.JCheckBox();
        lowZprecision = new javax.swing.JTextField();
        highZprecision = new javax.swing.JTextField();
        PlotDistr = new javax.swing.JButton();
        minLabel1 = new javax.swing.JLabel();
        maxLabel1 = new javax.swing.JLabel();
        minLabel2 = new javax.swing.JLabel();
        maxLabel2 = new javax.swing.JLabel();
        AlignChannels = new javax.swing.JButton();
        ChannelAlign = new javax.swing.JCheckBox();
        MinPtsLabel_ChAlign = new javax.swing.JLabel();
        lowChAlignBinCount = new javax.swing.JTextField();
        stepsizeZchAlign = new javax.swing.JTextField();
        stepsizeXYchAlign = new javax.swing.JTextField();
        stepSizeLabel_ChAlign = new javax.swing.JLabel();
        minLabel3 = new javax.swing.JLabel();
        maxLabel3 = new javax.swing.JLabel();
        highChAlignBinCount = new javax.swing.JTextField();

        basicSettingsLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        basicSettingsLabel.setText("Basic settings");

        advancedSettingsLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        advancedSettingsLabel.setText("Advanced settings");

        pixelSizeLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        pixelSizeLabel.setText("Input pixel size [nm]:");

        pixelSize.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        pixelSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pixelSize.setText("100");
        pixelSize.setMargin(new java.awt.Insets(0, 2, 0, 2));

        outpPixelSize.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        outpPixelSize.setText("Output pixel size [nm]:");
        outpPixelSize.setToolTipText("Pixel size of rendered output image.");

        desiredPixelSize.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        desiredPixelSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desiredPixelSize.setText("5");
        desiredPixelSize.setMargin(new java.awt.Insets(0, 2, 0, 2));

        medianWindowLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        medianWindowLabel.setText("Time window [frames]:");
        medianWindowLabel.setToolTipText("Used for time median background filtering. Odd number frames, including center frame and window-1 forward and backwards in time. ");

        medianWindow.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        medianWindow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        medianWindow.setText("101");
        medianWindow.setToolTipText("Uneven number");
        medianWindow.setMargin(new java.awt.Insets(0, 2, 0, 2));

        gWindowLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        gWindowLabel.setText("ROI size [pixels]:");
        gWindowLabel.setToolTipText("Extracted region for gaussian fit of particles");

        gWindow.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3x3", "5x5", "7x7" }));
        gWindow.setSelectedIndex(1);
        gWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gWindowActionPerformed(evt);
            }
        });

        positivePixelsLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        positivePixelsLabel.setText("Pixels > background:");
        positivePixelsLabel.setToolTipText("Number of pixels within the ROI, including the center, that needs to be stronger then background.");

        positivePixels.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        positivePixels.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        positivePixels.setText("9");
        positivePixels.setMargin(new java.awt.Insets(0, 2, 0, 2));

        MinSignal_Label.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        MinSignal_Label.setText("Minimal signal:");
        MinSignal_Label.setToolTipText("Pixel signal intensity to be extracted for gaussian fit");

        MinSignal.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        MinSignal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MinSignal.setText("2000");
        MinSignal.setMargin(new java.awt.Insets(0, 2, 0, 2));

        Chi_low.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        Chi_low.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Chi_low.setText("0.0");
        Chi_low.setMargin(new java.awt.Insets(0, 2, 0, 2));

        Chi_high.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        Chi_high.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Chi_high.setText("1.0");
        Chi_high.setMargin(new java.awt.Insets(0, 2, 0, 2));

        xyDriftLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        xyDriftLabel.setText("Max drift in x-y [nm]:");
        xyDriftLabel.setToolTipText("Max x and y drift to be considered ok for each time bin during drift corrections.");

        zDriftLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        zDriftLabel.setText("Max drift in z [nm]:");
        zDriftLabel.setToolTipText("Max z drift to be considered ok for each time bin during drift corrections.");

        xyDrift.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        xyDrift.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        xyDrift.setText("250");
        xyDrift.setMargin(new java.awt.Insets(0, 2, 0, 2));

        zDrift.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        zDrift.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        zDrift.setText("0");
        zDrift.setMargin(new java.awt.Insets(0, 2, 0, 2));

        Process.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        Process.setText("Process");
        Process.setToolTipText("Process selected timeseries of data.");
        Process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessActionPerformed(evt);
            }
        });

        correctBackground.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        correctBackground.setText("Correct background");
        correctBackground.setToolTipText("Correct background in selected imagestack.");
        correctBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correctBackgroundActionPerformed(evt);
            }
        });

        localize.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        localize.setText("Localize particles");
        localize.setToolTipText("Localize particles using gaussian fit for the selected background corrected imagestack.");
        localize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localizeActionPerformed(evt);
            }
        });

        driftCorrect.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        driftCorrect.setText("Drift correct");
        driftCorrect.setToolTipText("Correct for drift between time bins from the selected results table. Will update the table with new coordinate values.");
        driftCorrect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driftCorrectActionPerformed(evt);
            }
        });

        ClusterAnalysis.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        ClusterAnalysis.setText("Cluster analysis");
        ClusterAnalysis.setToolTipText("Perform density based cluster analysis with current values. Generates new particle table with center of clusters and renders image.");
        ClusterAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClusterAnalysisActionPerformed(evt);
            }
        });

        render.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        render.setText("Render image");
        render.setToolTipText("Render a image based on selected table of results.");
        render.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderActionPerformed(evt);
            }
        });

        cleanTable.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        cleanTable.setText("Clean results table");
        cleanTable.setToolTipText("Remove particles not corresponding to the current range of parameters.");
        cleanTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanTableActionPerformed(evt);
            }
        });

        MinPartDistLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        MinPartDistLabel.setText("Minimum particle distance [pixels]:");
        MinPartDistLabel.setToolTipText("Minimum distance between particles to be included.");

        lowPhotonCount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lowPhotonCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lowPhotonCount.setText("100");
        lowPhotonCount.setMargin(new java.awt.Insets(0, 2, 0, 2));
        lowPhotonCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowPhotonCountActionPerformed(evt);
            }
        });

        highPhotonCount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        highPhotonCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highPhotonCount.setText("5000");
        highPhotonCount.setMargin(new java.awt.Insets(0, 2, 0, 2));

        lowSigma.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lowSigma.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lowSigma.setText("10");
        lowSigma.setMargin(new java.awt.Insets(0, 2, 0, 2));

        highSigma.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        highSigma.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highSigma.setText("300");
        highSigma.setMargin(new java.awt.Insets(0, 2, 0, 2));

        headerSelect.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        headerSelect.setText("Included particle range");

        lowSigmaZ.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lowSigmaZ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lowSigmaZ.setText("0");
        lowSigmaZ.setMargin(new java.awt.Insets(0, 2, 0, 2));

        highSigmaZ.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        highSigmaZ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highSigmaZ.setText("300");
        highSigmaZ.setMargin(new java.awt.Insets(0, 2, 0, 2));

        lowPrecisionXY.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lowPrecisionXY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lowPrecisionXY.setText("5");
        lowPrecisionXY.setMargin(new java.awt.Insets(0, 2, 0, 2));

        highPrecisionXY.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        highPrecisionXY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highPrecisionXY.setText("50");
        highPrecisionXY.setMargin(new java.awt.Insets(0, 2, 0, 2));

        minPartClabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        minPartClabel.setText("Particles count per bin");

        driftLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        driftLabel.setText("Drift correction settings");

        lowDriftBinCount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lowDriftBinCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lowDriftBinCount.setText("100");
        lowDriftBinCount.setMargin(new java.awt.Insets(0, 2, 0, 2));
        lowDriftBinCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowDriftBinCountActionPerformed(evt);
            }
        });

        highDriftBinCount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        highDriftBinCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highDriftBinCount.setText("1000");
        highDriftBinCount.setMargin(new java.awt.Insets(0, 2, 0, 2));
        highDriftBinCount.setPreferredSize(new java.awt.Dimension(40, 15));
        highDriftBinCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highDriftBinCountActionPerformed(evt);
            }
        });

        stepSizeLabe.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        stepSizeLabe.setText("Stepsize XY / Z [nm]:");
        stepSizeLabe.setToolTipText("Step size for drift correction. Smaller step size results in slower calculation times.");

        stepsizeXY.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        stepsizeXY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stepsizeXY.setText("5");
        stepsizeXY.setMargin(new java.awt.Insets(0, 2, 0, 2));

        stepsizeZ.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        stepsizeZ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stepsizeZ.setText("5");
        stepsizeZ.setMargin(new java.awt.Insets(0, 2, 0, 2));

        epsilonLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        epsilonLabel.setText("Search radius [nm]");

        epsilon.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        epsilon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        epsilon.setText("10");
        epsilon.setMargin(new java.awt.Insets(0, 2, 0, 2));
        epsilon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epsilonActionPerformed(evt);
            }
        });

        MinPtsLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        MinPtsLabel.setText("Particles in each bin:");
        MinPtsLabel.setToolTipText("Minimum and maximum number of particles to include in a bin. Increasing max will result in increase in processing time.");

        minPts.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        minPts.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        minPts.setText("5");
        minPts.setMargin(new java.awt.Insets(0, 2, 0, 2));

        doClusterAnalysis.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        doClusterAnalysis.setText("Cluster analysis");
        doClusterAnalysis.setToolTipText("Include cluster analysis in process and batch process.");

        binCountLabel.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        binCountLabel.setText("Number of bins:");
        binCountLabel.setToolTipText("Number of bins to split the data in time.");

        binCount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        binCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        binCount.setText("50");
        binCount.setMargin(new java.awt.Insets(0, 2, 0, 2));
        binCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binCountActionPerformed(evt);
            }
        });

        screenLabel.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        screenLabel.setText("SMlocalizer");

        inclPhotonCount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        inclPhotonCount.setText("Photon count");
        inclPhotonCount.setToolTipText("Calculated particle photon count");
        inclPhotonCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inclPhotonCountActionPerformed(evt);
            }
        });

        inclXYsigma.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        inclXYsigma.setSelected(true);
        inclXYsigma.setText("XY sigma [nm]:");
        inclXYsigma.setToolTipText("Gaussian fit sigma in x and y directions");

        inclZsigma.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        inclZsigma.setText("Z sigma [nm]:");
        inclZsigma.setToolTipText("Fit spread in z");

        inclChiSquare.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        inclChiSquare.setSelected(true);
        inclChiSquare.setText("Chi^2 range:");
        inclChiSquare.setToolTipText("pearson's chi square test. Value of 0 represents perfect fit.");

        inclXYprecision.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        inclXYprecision.setSelected(true);
        inclXYprecision.setText("XY precision [nm]:");
        inclXYprecision.setToolTipText("Precision of localization in x-y.");

        minParticleDistance.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        minParticleDistance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        minParticleDistance.setText("7");
        minParticleDistance.setMargin(new java.awt.Insets(0, 2, 0, 2));

        inclZprecision.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        inclZprecision.setText("Z precision [nm]:");
        inclZprecision.setToolTipText("Precicion of fit in z.");

        lowZprecision.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lowZprecision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lowZprecision.setText("0");
        lowZprecision.setMargin(new java.awt.Insets(0, 2, 0, 2));

        highZprecision.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        highZprecision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highZprecision.setText("50");
        highZprecision.setMargin(new java.awt.Insets(0, 2, 0, 2));

        PlotDistr.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        PlotDistr.setText("Plot distributions");
        PlotDistr.setToolTipText("Plot parameter distribution of particles in selected results table.");
        PlotDistr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlotDistrActionPerformed(evt);
            }
        });

        minLabel1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        minLabel1.setText("Low");

        maxLabel1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        maxLabel1.setText("High");

        minLabel2.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        minLabel2.setText("Low");

        maxLabel2.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        maxLabel2.setText("High");

        AlignChannels.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        AlignChannels.setText("Align channels");
        AlignChannels.setToolTipText("Align all channels.");
        AlignChannels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlignChannelsActionPerformed(evt);
            }
        });

        ChannelAlign.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ChannelAlign.setSelected(true);
        ChannelAlign.setText("Channel alignment");
        ChannelAlign.setToolTipText("Include channel alignments in process and batch process");

        MinPtsLabel_ChAlign.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        MinPtsLabel_ChAlign.setText("Particles in each bin:");
        MinPtsLabel_ChAlign.setToolTipText("Minimum and maximum number of particles to include in a bin. Increasing max will result in increase in processing time.");

        lowChAlignBinCount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lowChAlignBinCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lowChAlignBinCount.setText("100");
        lowChAlignBinCount.setMargin(new java.awt.Insets(0, 2, 0, 2));
        lowChAlignBinCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowChAlignBinCountActionPerformed(evt);
            }
        });

        stepsizeZchAlign.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        stepsizeZchAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stepsizeZchAlign.setText("5");
        stepsizeZchAlign.setMargin(new java.awt.Insets(0, 2, 0, 2));

        stepsizeXYchAlign.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        stepsizeXYchAlign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stepsizeXYchAlign.setText("5");
        stepsizeXYchAlign.setMargin(new java.awt.Insets(0, 2, 0, 2));
        stepsizeXYchAlign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepsizeXYchAlignActionPerformed(evt);
            }
        });

        stepSizeLabel_ChAlign.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        stepSizeLabel_ChAlign.setText("Stepsize XY / Z [nm]:");
        stepSizeLabel_ChAlign.setToolTipText("Step size for channel alignment correction. Smaller step size results in slower calculation times.");

        minLabel3.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        minLabel3.setText("Low");

        maxLabel3.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        maxLabel3.setText("High");

        highChAlignBinCount.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        highChAlignBinCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highChAlignBinCount.setText("2000");
        highChAlignBinCount.setMargin(new java.awt.Insets(0, 2, 0, 2));
        highChAlignBinCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highChAlignBinCountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Process)
                    .addComponent(render)
                    .addComponent(correctBackground)
                    .addComponent(localize)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(zDriftLabel)
                                        .addComponent(xyDriftLabel))
                                    .addGap(21, 21, 21))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(basicSettingsLabel)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(positivePixelsLabel)
                                            .addComponent(outpPixelSize)
                                            .addComponent(medianWindowLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(gWindowLabel)
                                            .addComponent(MinSignal_Label)))
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pixelSizeLabel)
                                .addGap(25, 25, 25)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gWindow, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(desiredPixelSize)
                            .addComponent(pixelSize)
                            .addComponent(zDrift)
                            .addComponent(xyDrift)
                            .addComponent(MinSignal)
                            .addComponent(positivePixels)
                            .addComponent(medianWindow)))
                    .addComponent(AlignChannels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(driftCorrect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inclXYprecision)
                                            .addComponent(inclPhotonCount)
                                            .addComponent(inclXYsigma)
                                            .addComponent(inclZsigma)
                                            .addComponent(inclChiSquare)
                                            .addComponent(inclZprecision))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(minLabel1)
                                                .addGap(29, 29, 29)
                                                .addComponent(maxLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lowZprecision)
                                                    .addComponent(lowPrecisionXY, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(Chi_low, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lowSigmaZ, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lowSigma, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lowPhotonCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(highZprecision, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(highPrecisionXY, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(highSigmaZ, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(highPhotonCount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                                            .addComponent(highSigma, javax.swing.GroupLayout.Alignment.LEADING)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(Chi_high, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PlotDistr)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cleanTable))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MinPartDistLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(minParticleDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(minPartClabel)
                                            .addComponent(epsilonLabel))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(epsilon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(minPts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(doClusterAnalysis)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ClusterAnalysis))
                                    .addComponent(headerSelect)
                                    .addComponent(ChannelAlign)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(driftLabel)
                                        .addGap(40, 40, 40)
                                        .addComponent(minLabel2)
                                        .addGap(28, 28, 28)
                                        .addComponent(maxLabel2)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(MinPtsLabel)
                                            .addGap(41, 41, 41)
                                            .addComponent(lowDriftBinCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(stepSizeLabe, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addComponent(stepsizeXY, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(binCountLabel)
                                            .addGap(64, 64, 64)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(minLabel3))
                                                .addComponent(binCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MinPtsLabel_ChAlign)
                                            .addComponent(stepSizeLabel_ChAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lowChAlignBinCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stepsizeXYchAlign, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(stepsizeZ)
                                            .addComponent(highDriftBinCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(stepsizeZchAlign)
                                            .addComponent(highChAlignBinCount)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(maxLabel3)))
                                .addGap(67, 67, 67))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(advancedSettingsLabel)
                                .addGap(141, 141, 141))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(screenLabel))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AlignChannels, ClusterAnalysis, Process, correctBackground, driftCorrect, localize, render});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {epsilon, minPts});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screenLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(advancedSettingsLabel)
                    .addComponent(basicSettingsLabel))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MinPartDistLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minParticleDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(headerSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minLabel1)
                            .addComponent(maxLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inclPhotonCount)
                            .addComponent(lowPhotonCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highPhotonCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inclXYsigma)
                            .addComponent(lowSigma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highSigma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lowSigmaZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highSigmaZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inclZsigma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inclChiSquare)
                            .addComponent(Chi_low, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Chi_high, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inclXYprecision)
                            .addComponent(lowPrecisionXY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highPrecisionXY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inclZprecision)
                            .addComponent(lowZprecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highZprecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PlotDistr)
                            .addComponent(cleanTable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(driftLabel)
                            .addComponent(minLabel2)
                            .addComponent(maxLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lowDriftBinCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highDriftBinCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinPtsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stepSizeLabe)
                            .addComponent(stepsizeXY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stepsizeZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(binCountLabel)
                            .addComponent(binCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChannelAlign)
                            .addComponent(minLabel3)
                            .addComponent(maxLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MinPtsLabel_ChAlign)
                            .addComponent(lowChAlignBinCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highChAlignBinCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stepSizeLabel_ChAlign, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stepsizeXYchAlign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stepsizeZchAlign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doClusterAnalysis)
                            .addComponent(ClusterAnalysis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(epsilon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(epsilonLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minPartClabel)
                            .addComponent(minPts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pixelSizeLabel)
                            .addComponent(pixelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outpPixelSize)
                            .addComponent(desiredPixelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medianWindowLabel)
                            .addComponent(medianWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gWindowLabel)
                            .addComponent(gWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(positivePixelsLabel)
                            .addComponent(positivePixels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MinSignal_Label)
                            .addComponent(MinSignal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xyDriftLabel)
                            .addComponent(xyDrift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(zDriftLabel)
                            .addComponent(zDrift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Process)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(render)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(correctBackground)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(localize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(driftCorrect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AlignChannels)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {desiredPixelSize, medianWindow, pixelSize, positivePixels});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AlignChannels, ClusterAnalysis, Process, cleanTable, correctBackground, driftCorrect, localize, render});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {highDriftBinCount, stepsizeZ});

        pack();
	}// </editor-fold>                        

	private void gWindowActionPerformed(java.awt.event.ActionEvent evt) {                                        

	}                                       

	private void lowPhotonCountActionPerformed(java.awt.event.ActionEvent evt) {                                               

	}                                              

	private void highDriftBinCountActionPerformed(java.awt.event.ActionEvent evt) {                                                  

	}                                                 

	private void binCountActionPerformed(java.awt.event.ActionEvent evt) {                                         

	}                                        

	private void lowDriftBinCountActionPerformed(java.awt.event.ActionEvent evt) {                                                 

	}                                                

	private void epsilonActionPerformed(java.awt.event.ActionEvent evt) {                                        

	}                                       

	private void lowChAlignBinCountActionPerformed(java.awt.event.ActionEvent evt) {                                                   

	}                                                  

	private void highChAlignBinCountActionPerformed(java.awt.event.ActionEvent evt) {                                                    

	}                                                   

	private void inclPhotonCountActionPerformed(java.awt.event.ActionEvent evt) {                                                

	}   

	private void stepsizeXYchAlignActionPerformed(java.awt.event.ActionEvent evt) {                                                  

	}                                                 

	/*
	 * Action buttons call backs:
	 */

	/*
	 * Process.
	 */

	private void ProcessActionPerformed(java.awt.event.ActionEvent evt) {                                        
		// Call all functions in sequence, include calls to cluster analysis if checked and so on. 
		correctBackgroundActionPerformed(evt);  // Correct background.
		localizeActionPerformed(evt); 			// Localize events.
		driftCorrectActionPerformed(evt);		// Correct for drift if possible.

		if (doClusterAnalysis.isSelected()){ 	// If user wants to do cluster analysis.
			ClusterAnalysisActionPerformed(evt); // Do cluster analysis
		}else{
			renderActionPerformed(evt); 		// Otherwise, render drift corrected image.
		}

		// Get variables.
		/*
        int InputpixelSize = Integer.parseInt(pixelSize.getText());
        int OutputpixelSize = Integer.parseInt(desiredPixelSize.getText());
        int ROIpositivePixels = Integer.parseInt(positivePixels.getText());
        double SignalNoise = Double.parseDouble(SN.getText());        
        int DriftXY = Integer.parseInt(xyDrift.getText());
        int DriftZ = Integer.parseInt(zDrift.getText());
        double Distance = Double.parseDouble(minParticleDistance.getText());
        int photonLow = Integer.parseInt(lowPhotonCount.getText());
        int photonHigh = Integer.parseInt(highPhotonCount.getText());
        int SigmaLow = Integer.parseInt(lowSigma.getText());
        int SigmaHigh = Integer.parseInt(highSigma.getText());
        int ZSigmaLow = Integer.parseInt(lowSigmaZ.getText());
        int ZSigmaHigh = Integer.parseInt(highSigmaZ.getText());
        double ChiSquareLow = Double.parseDouble(Chi_low.getText());
        double ChiSquareHigh = Double.parseDouble(Chi_high.getText());                
        int PrecisionLow = Integer.parseInt(lowPrecisionXY.getText());
        int PrecisionHigh = Integer.parseInt(highPrecisionXY.getText());
        int PrecisionLowZ = Integer.parseInt(lowZprecision.getText());
        int PrecisionHighZ = Integer.parseInt(highZprecision.getText());

        int minBin = Integer.parseInt(lowDriftBinCount.getText());
        int maxBin = Integer.parseInt(highDriftBinCount.getText());
        int StepXY = Integer.parseInt(stepsizeXY.getText());
        int StepZ = Integer.parseInt(stepsizeZ.getText());
        int BinCount = Integer.parseInt(binCount.getText());

        int ChminBin = Integer.parseInt(lowChAlignBinCount.getText());
        int ChmaxBin = Integer.parseInt(highChAlignBinCount.getText());
        int ChStepXY = Integer.parseInt(stepsizeXYchAlign.getText());
        int ChStepZ = Integer.parseInt(stepsizeZchAlign.getText());        

        int Epsilon = Integer.parseInt(epsilon.getText());
        int minPt = Integer.parseInt(minPts.getText());



        int ROIWindow = gWindow.getSelectedIndex();
       // System.out.println(ROIWindow);       

       // Checkboxes:
        boolean limitPhotonC = inclPhotonCount.isSelected();
        boolean limitSigma = inclXYsigma.isSelected();
        boolean limitSigmaZ = inclZsigma.isSelected();
        boolean limitChi = inclChiSquare.isSelected();
        boolean limitPrecision = inclXYprecision.isSelected();
        boolean limitPrecisionZ = inclZprecision.isSelected();
        boolean performChAlign = ChannelAlign.isSelected();
        boolean performCluster = doClusterAnalysis.isSelected();


		 */
	}                                       

	/*
	 * Correct background.
	 */

	private void correctBackgroundActionPerformed(java.awt.event.ActionEvent evt) {                                                  
		int Window; // Initiate. 
		try {
			Window = Integer.parseInt(medianWindow.getText()); // Try to convert value to string.
			int W = (Window-1)/2; // window in one direction.		
			filterBackground.run(W); // Need to find out how multi channel images are organized for multi channel functions.
		} catch (NumberFormatException e) { // If user wrote non numerical test into the field.
			Window = 101;                 // Default value.
			medianWindow.setText(String.valueOf(Window)); // Update.
		}            

	}            

	/*
	 * Localize.
	 */

	private void localizeActionPerformed(java.awt.event.ActionEvent evt) {                                                     
		int ROIWindow = gWindow.getSelectedIndex();
		int[] possibleWindows =	{3,5,7};    			
		int gWindow = possibleWindows[ROIWindow];

		int ROIpositivePixels; // Initiate. 
		try {
			ROIpositivePixels = Integer.parseInt(positivePixels.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ROIpositivePixels = 9;                 							// Default value.
			positivePixels.setText(String.valueOf(ROIpositivePixels)); 		// Update.
		}    

		double SignalNoise;        
		try {
			SignalNoise = Double.parseDouble(MinSignal.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SignalNoise = 2;                 								// Default value.
			MinSignal.setText(String.valueOf(SignalNoise)); 						// Update.
		}   

		double Distance;
		try {
			Distance = Double.parseDouble(minParticleDistance.getText());        		
		} catch (NumberFormatException e) { 							// If user wrote non numerical test into the field.
			Distance = 7;                 								// Default value.
			minParticleDistance.setText(String.valueOf(Distance)); 		// Update.
		} 

		int inputPixelSize;
		try {
			inputPixelSize = Integer.parseInt(pixelSize.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			inputPixelSize = 100;                 							// Default value.
			pixelSize.setText(String.valueOf(inputPixelSize)); 		// Update.
		}    
		localizeAndFit.run(SignalNoise, Distance*Distance, gWindow, inputPixelSize,ROIpositivePixels); // 2D. Need to find out how multi channel images are organized for multi channel functions.
	}  

	/*
	 * Render
	 */

	private void renderActionPerformed(java.awt.event.ActionEvent evt) {                                        
		
		/*
		 * Clean out list first.
		 */
		/*
		 * Update table based on user parameter settings
		 */

		int photonLow; // Initiate. 
		try {
			photonLow = Integer.parseInt(lowPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonLow = 0;                 							// Default value.
			lowPhotonCount.setText(String.valueOf(photonLow)); 		// Update.
		}    

		int photonHigh; // Initiate. 
		try {
			photonHigh = Integer.parseInt(highPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonHigh = 5000;                 							// Default value.
			highPhotonCount.setText(String.valueOf(photonHigh)); 		// Update.
		}  
		int SigmaLow; // Initiate. 
		try {
			SigmaLow = Integer.parseInt(lowSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaLow = 300;                 							// Default value.
			lowSigma.setText(String.valueOf(SigmaLow)); 		// Update.
		}  
		int SigmaHigh; // Initiate. 
		try {
			SigmaHigh = Integer.parseInt(highSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaHigh = 300;                 							// Default value.
			highSigma.setText(String.valueOf(SigmaHigh)); 		// Update.
		}  
		int ZSigmaLow; // Initiate. 
		try {
			ZSigmaLow = Integer.parseInt(lowSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaLow = 0;                 							// Default value.
			lowSigmaZ.setText(String.valueOf(ZSigmaLow)); 		// Update.
		}  
		int ZSigmaHigh; // Initiate. 
		try {
			ZSigmaHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaHigh = 300;                 							// Default value.
			highSigmaZ.setText(String.valueOf(ZSigmaHigh)); 		// Update.
		}         
		double ChiSquareLow;        
		try {
			ChiSquareLow = Double.parseDouble(Chi_low.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareLow = 0.0;                 								// Default value.
			Chi_low.setText(String.valueOf(ChiSquareLow)); 						// Update.
		}  
		double ChiSquareHigh;        
		try {
			ChiSquareHigh = Double.parseDouble(Chi_high.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareHigh = 1.0;                 								// Default value.
			Chi_high.setText(String.valueOf(ChiSquareHigh)); 						// Update.
		}
		int PrecisionLow; // Initiate. 
		try {
			PrecisionLow = Integer.parseInt(lowPrecisionXY.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLow = 0;                 							// Default value.
			lowPrecisionXY.setText(String.valueOf(PrecisionLow)); 		// Update.
		}  
		int PrecisionHigh; // Initiate. 
		try {
			PrecisionHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHigh = 50;                 							// Default value.
			highPrecisionXY.setText(String.valueOf(PrecisionHigh)); 		// Update.
		} 
		int PrecisionLowZ; // Initiate. 
		try {
			PrecisionLowZ = Integer.parseInt(lowZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLowZ = 0;                 							// Default value.
			lowZprecision.setText(String.valueOf(PrecisionLowZ)); 		// Update.
		}  
		int PrecisionHighZ; // Initiate. 
		try {
			PrecisionHighZ = Integer.parseInt(highZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHighZ = 50;                 							// Default value.
			highZprecision.setText(String.valueOf(PrecisionHighZ)); 		// Update.
		}         
		boolean[] Include = new boolean[6];



		Include[0] = inclXYsigma.isSelected();
		Include[1] = inclZsigma.isSelected();        
		Include[2] = inclXYprecision.isSelected();
		Include[3] = inclZprecision.isSelected();
		Include[4] = inclChiSquare.isSelected();
		Include[5] = inclPhotonCount.isSelected();

		double[] lb = {
				SigmaLow,								// Allowed lower range of sigma_x in nm, user input.
				SigmaLow,								// Allowed lower range of sigma_y in nm, user input.
				ZSigmaLow,								// Allowed lower range of sigma_z in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_x in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_y in nm, user input.
				PrecisionLowZ,								// Allowed lower range of precision_z in nm, user input.
				ChiSquareLow,								// Allowed lower range of chi_square, user input.
				photonLow								// Allowed lower range of photon count, user input.
		};  				
		double[] ub = {
				SigmaHigh,						// Allowed upper range of sigma_x in nm, user input.
				SigmaHigh,						// Allowed upper range of sigma_y in nm, user input.
				ZSigmaHigh,						// Allowed upper range of sigma_z in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_x in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_y in nm, user input.
				PrecisionHighZ,						// Allowed upper range of precision_z in nm, user input.
				ChiSquareHigh,						// Allowed upper range of chi_square, user input.
				photonHigh					// Allowed upper range of photon count, user input.
		};


		cleanParticleList.run(lb,ub,Include);
		
		
		
		int inputPixelSize; // Initiate. 
		try {
			inputPixelSize = Integer.parseInt(pixelSize.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			inputPixelSize = 100;                 							// Default value.
			pixelSize.setText(String.valueOf(inputPixelSize)); 		// Update.
		}  
		int DesiredPixelSize; // Initiate. 
		try {
			DesiredPixelSize = Integer.parseInt(desiredPixelSize.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			DesiredPixelSize = 5;                 							// Default value.
			desiredPixelSize.setText(String.valueOf(DesiredPixelSize)); 		// Update.
		}  
		renderImage.run(inputPixelSize,DesiredPixelSize); // Not 3D yet, how to implement? Need to find out how multi channel images are organized for multi channel functions.

	}                                      


	/*
	 * Drift correct.
	 */

	private void driftCorrectActionPerformed(java.awt.event.ActionEvent evt) {                                                    
		/*
		 * Update table based on user parameter settings
		 */

		int photonLow; // Initiate. 
		try {
			photonLow = Integer.parseInt(lowPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonLow = 0;                 							// Default value.
			lowPhotonCount.setText(String.valueOf(photonLow)); 		// Update.
		}    

		int photonHigh; // Initiate. 
		try {
			photonHigh = Integer.parseInt(highPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonHigh = 5000;                 							// Default value.
			highPhotonCount.setText(String.valueOf(photonHigh)); 		// Update.
		}  
		int SigmaLow; // Initiate. 
		try {
			SigmaLow = Integer.parseInt(lowSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaLow = 300;                 							// Default value.
			lowSigma.setText(String.valueOf(SigmaLow)); 		// Update.
		}  
		int SigmaHigh; // Initiate. 
		try {
			SigmaHigh = Integer.parseInt(highSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaHigh = 300;                 							// Default value.
			highSigma.setText(String.valueOf(SigmaHigh)); 		// Update.
		}  
		int ZSigmaLow; // Initiate. 
		try {
			ZSigmaLow = Integer.parseInt(lowSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaLow = 0;                 							// Default value.
			lowSigmaZ.setText(String.valueOf(ZSigmaLow)); 		// Update.
		}  
		int ZSigmaHigh; // Initiate. 
		try {
			ZSigmaHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaHigh = 300;                 							// Default value.
			highSigmaZ.setText(String.valueOf(ZSigmaHigh)); 		// Update.
		}         
		double ChiSquareLow;        
		try {
			ChiSquareLow = Double.parseDouble(Chi_low.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareLow = 0.0;                 								// Default value.
			Chi_low.setText(String.valueOf(ChiSquareLow)); 						// Update.
		}  
		double ChiSquareHigh;        
		try {
			ChiSquareHigh = Double.parseDouble(Chi_high.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareHigh = 1.0;                 								// Default value.
			Chi_high.setText(String.valueOf(ChiSquareHigh)); 						// Update.
		}
		int PrecisionLow; // Initiate. 
		try {
			PrecisionLow = Integer.parseInt(lowPrecisionXY.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLow = 0;                 							// Default value.
			lowPrecisionXY.setText(String.valueOf(PrecisionLow)); 		// Update.
		}  
		int PrecisionHigh; // Initiate. 
		try {
			PrecisionHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHigh = 50;                 							// Default value.
			highPrecisionXY.setText(String.valueOf(PrecisionHigh)); 		// Update.
		} 
		int PrecisionLowZ; // Initiate. 
		try {
			PrecisionLowZ = Integer.parseInt(lowZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLowZ = 0;                 							// Default value.
			lowZprecision.setText(String.valueOf(PrecisionLowZ)); 		// Update.
		}  
		int PrecisionHighZ; // Initiate. 
		try {
			PrecisionHighZ = Integer.parseInt(highZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHighZ = 50;                 							// Default value.
			highZprecision.setText(String.valueOf(PrecisionHighZ)); 		// Update.
		}         
		boolean[] Include = new boolean[6];



		Include[0] = inclXYsigma.isSelected();
		Include[1] = inclZsigma.isSelected();        
		Include[2] = inclXYprecision.isSelected();
		Include[3] = inclZprecision.isSelected();
		Include[4] = inclChiSquare.isSelected();
		Include[5] = inclPhotonCount.isSelected();

		double[] lb = {
				SigmaLow,								// Allowed lower range of sigma_x in nm, user input.
				SigmaLow,								// Allowed lower range of sigma_y in nm, user input.
				ZSigmaLow,								// Allowed lower range of sigma_z in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_x in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_y in nm, user input.
				PrecisionLowZ,								// Allowed lower range of precision_z in nm, user input.
				ChiSquareLow,								// Allowed lower range of chi_square, user input.
				photonLow								// Allowed lower range of photon count, user input.
		};  				
		double[] ub = {
				SigmaHigh,						// Allowed upper range of sigma_x in nm, user input.
				SigmaHigh,						// Allowed upper range of sigma_y in nm, user input.
				ZSigmaHigh,						// Allowed upper range of sigma_z in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_x in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_y in nm, user input.
				PrecisionHighZ,						// Allowed upper range of precision_z in nm, user input.
				ChiSquareHigh,						// Allowed upper range of chi_square, user input.
				photonHigh					// Allowed upper range of photon count, user input.
		};


		cleanParticleList.run(lb,ub,Include);


		/*
		 * Correct drift based on user input parameters. Get parameters:
		 */

		int minParticles; // Initiate. 
		try {
			minParticles = Integer.parseInt(lowDriftBinCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			minParticles = 100;                 							// Default value.
			lowDriftBinCount.setText(String.valueOf(minParticles)); 		// Update.
		}  
		int nParticles; // Initiate. 
		try {
			nParticles = Integer.parseInt(highDriftBinCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			nParticles = 1000;                 							// Default value.
			highDriftBinCount.setText(String.valueOf(nParticles)); 		// Update.
		}
		int StepXY; // Initiate. 
		try {
			StepXY = Integer.parseInt(stepsizeXY.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			StepXY = 5;                 							// Default value.
			stepsizeXY.setText(String.valueOf(StepXY)); 		// Update.
		}  
		int StepZ; // Initiate. 
		try {
			StepZ = Integer.parseInt(stepsizeZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			StepZ = 5;                 							// Default value.
			stepsizeZ.setText(String.valueOf(StepZ)); 		// Update.
		}
		int BinCount; // Initiate. 
		try {
			BinCount = Integer.parseInt(binCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			BinCount = 50;                 							// Default value.
			binCount.setText(String.valueOf(BinCount)); 		// Update.
		}
		int DriftXY; // Initiate. 
		try {
			DriftXY = Integer.parseInt(xyDrift.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			DriftXY = 250;                 							// Default value.
			xyDrift.setText(String.valueOf(DriftXY)); 		// Update.
		}
		int DriftZ; // Initiate. 
		try {
			DriftZ = Integer.parseInt(zDrift.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			DriftZ = 250;                 							// Default value.
			zDrift.setText(String.valueOf(DriftZ)); 		// Update.
		}

		int[] lowBoundry = {-DriftXY,-DriftXY,-DriftZ};
		int[] upperBoundry = {DriftXY,DriftXY,DriftZ};

		double BinFrac				= 1.0/BinCount;							// Fraction of total frames in each bin for drift corrrection. User input.
		int[] stepSize 				= {StepXY,StepXY,StepZ};						// Stepsize in nm, user input.

		correctDrift.run(lowBoundry, upperBoundry, BinFrac, nParticles, minParticles, stepSize); // 3D version now requires doublechecking. Also handles multi channel data.

	}                                            

	/*
	 * Align channels.
	 */

	private void AlignChannelsActionPerformed(java.awt.event.ActionEvent evt) {                                                  
		/*
		 * Update table based on user parameter settings
		 */

		int photonLow; // Initiate. 
		try {
			photonLow = Integer.parseInt(lowPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonLow = 0;                 							// Default value.
			lowPhotonCount.setText(String.valueOf(photonLow)); 		// Update.
		}    

		int photonHigh; // Initiate. 
		try {
			photonHigh = Integer.parseInt(highPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonHigh = 5000;                 							// Default value.
			highPhotonCount.setText(String.valueOf(photonHigh)); 		// Update.
		}  
		int SigmaLow; // Initiate. 
		try {
			SigmaLow = Integer.parseInt(lowSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaLow = 300;                 							// Default value.
			lowSigma.setText(String.valueOf(SigmaLow)); 		// Update.
		}  
		int SigmaHigh; // Initiate. 
		try {
			SigmaHigh = Integer.parseInt(highSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaHigh = 300;                 							// Default value.
			highSigma.setText(String.valueOf(SigmaHigh)); 		// Update.
		}  
		int ZSigmaLow; // Initiate. 
		try {
			ZSigmaLow = Integer.parseInt(lowSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaLow = 0;                 							// Default value.
			lowSigmaZ.setText(String.valueOf(ZSigmaLow)); 		// Update.
		}  
		int ZSigmaHigh; // Initiate. 
		try {
			ZSigmaHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaHigh = 300;                 							// Default value.
			highSigmaZ.setText(String.valueOf(ZSigmaHigh)); 		// Update.
		}         
		double ChiSquareLow;        
		try {
			ChiSquareLow = Double.parseDouble(Chi_low.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareLow = 0.0;                 								// Default value.
			Chi_low.setText(String.valueOf(ChiSquareLow)); 						// Update.
		}  
		double ChiSquareHigh;        
		try {
			ChiSquareHigh = Double.parseDouble(Chi_high.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareHigh = 1.0;                 								// Default value.
			Chi_high.setText(String.valueOf(ChiSquareHigh)); 						// Update.
		}
		int PrecisionLow; // Initiate. 
		try {
			PrecisionLow = Integer.parseInt(lowPrecisionXY.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLow = 0;                 							// Default value.
			lowPrecisionXY.setText(String.valueOf(PrecisionLow)); 		// Update.
		}  
		int PrecisionHigh; // Initiate. 
		try {
			PrecisionHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHigh = 50;                 							// Default value.
			highPrecisionXY.setText(String.valueOf(PrecisionHigh)); 		// Update.
		} 
		int PrecisionLowZ; // Initiate. 
		try {
			PrecisionLowZ = Integer.parseInt(lowZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLowZ = 0;                 							// Default value.
			lowZprecision.setText(String.valueOf(PrecisionLowZ)); 		// Update.
		}  
		int PrecisionHighZ; // Initiate. 
		try {
			PrecisionHighZ = Integer.parseInt(highZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHighZ = 50;                 							// Default value.
			highZprecision.setText(String.valueOf(PrecisionHighZ)); 		// Update.
		}         
		boolean[] Include = new boolean[6];



		Include[0] = inclXYsigma.isSelected();
		Include[1] = inclZsigma.isSelected();        
		Include[2] = inclXYprecision.isSelected();
		Include[3] = inclZprecision.isSelected();
		Include[4] = inclChiSquare.isSelected();
		Include[5] = inclPhotonCount.isSelected();

		double[] lb = {
				SigmaLow,								// Allowed lower range of sigma_x in nm, user input.
				SigmaLow,								// Allowed lower range of sigma_y in nm, user input.
				ZSigmaLow,								// Allowed lower range of sigma_z in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_x in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_y in nm, user input.
				PrecisionLowZ,								// Allowed lower range of precision_z in nm, user input.
				ChiSquareLow,								// Allowed lower range of chi_square, user input.
				photonLow								// Allowed lower range of photon count, user input.
		};  				
		double[] ub = {
				SigmaHigh,						// Allowed upper range of sigma_x in nm, user input.
				SigmaHigh,						// Allowed upper range of sigma_y in nm, user input.
				ZSigmaHigh,						// Allowed upper range of sigma_z in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_x in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_y in nm, user input.
				PrecisionHighZ,						// Allowed upper range of precision_z in nm, user input.
				ChiSquareHigh,						// Allowed upper range of chi_square, user input.
				photonHigh					// Allowed upper range of photon count, user input.
		};


		cleanParticleList.run(lb,ub,Include);

		/*
		 * Align channels based on user parameters.
		 */

		int minParticles; // Initiate. 
		try {
			minParticles = Integer.parseInt(lowChAlignBinCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			minParticles = 100;                 							// Default value.
			lowChAlignBinCount.setText(String.valueOf(minParticles)); 		// Update.
		}  
		int nParticles; // Initiate. 
		try {
			nParticles = Integer.parseInt(highChAlignBinCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			nParticles = 2000;                 							// Default value.
			highChAlignBinCount.setText(String.valueOf(nParticles)); 		// Update.
		}
		int StepXY; // Initiate. 
		try {
			StepXY = Integer.parseInt(stepsizeXYchAlign.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			StepXY = 5;                 							// Default value.
			stepsizeXYchAlign.setText(String.valueOf(StepXY)); 		// Update.
		}  
		int StepZ; // Initiate. 
		try {
			StepZ = Integer.parseInt(stepsizeZchAlign.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			StepZ = 5;                 							// Default value.
			stepsizeZchAlign.setText(String.valueOf(StepZ)); 		// Update.
		}
		int BinCount; // Initiate. 
		try {
			BinCount = Integer.parseInt(binCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			BinCount = 50;                 							// Default value.
			binCount.setText(String.valueOf(BinCount)); 		// Update.
		}
		int DriftXY; // Initiate. 
		try {
			DriftXY = Integer.parseInt(xyDrift.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			DriftXY = 250;                 							// Default value.
			xyDrift.setText(String.valueOf(DriftXY)); 		// Update.
		}
		int DriftZ; // Initiate. 
		try {
			DriftZ = Integer.parseInt(zDrift.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			DriftZ = 250;                 							// Default value.
			zDrift.setText(String.valueOf(DriftZ)); 		// Update.
		}

		int[] lowBoundry 	= {-DriftXY,-DriftXY,-DriftZ};
		int[] upperBoundry 	= {DriftXY,DriftXY,DriftZ};        
		int[] stepSize 		= {StepXY,StepXY,StepZ};						// Stepsize in nm, user input.

		correctDrift.ChannelAlign(lowBoundry, upperBoundry, nParticles, minParticles, stepSize);      
	}                                             

	/*
	 * Batch process.
	 */

/*	private void BatchPActionPerformed(java.awt.event.ActionEvent evt) {                                       
		System.out.println("Batch process button");
		// ToDo: Develop.
	}*/            

	/*
	 * Plot parameter distributions.
	 */

	private void PlotDistrActionPerformed(java.awt.event.ActionEvent evt) {                                          
		parameterDistribution.run();

	}                               

	/*
	 * Clean results table.
	 */

	private void cleanTableActionPerformed(java.awt.event.ActionEvent evt) {                                                  
		/*
		 * Update table based on user parameter settings
		 */

		int photonLow; // Initiate. 
		try {
			photonLow = Integer.parseInt(lowPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonLow = 0;                 							// Default value.
			lowPhotonCount.setText(String.valueOf(photonLow)); 		// Update.
		}    

		int photonHigh; // Initiate. 
		try {
			photonHigh = Integer.parseInt(highPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonHigh = 5000;                 							// Default value.
			highPhotonCount.setText(String.valueOf(photonHigh)); 		// Update.
		}  
		int SigmaLow; // Initiate. 
		try {
			SigmaLow = Integer.parseInt(lowSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaLow = 300;                 							// Default value.
			lowSigma.setText(String.valueOf(SigmaLow)); 		// Update.
		}  
		int SigmaHigh; // Initiate. 
		try {
			SigmaHigh = Integer.parseInt(highSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaHigh = 300;                 							// Default value.
			highSigma.setText(String.valueOf(SigmaHigh)); 		// Update.
		}  
		int ZSigmaLow; // Initiate. 
		try {
			ZSigmaLow = Integer.parseInt(lowSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaLow = 0;                 							// Default value.
			lowSigmaZ.setText(String.valueOf(ZSigmaLow)); 		// Update.
		}  
		int ZSigmaHigh; // Initiate. 
		try {
			ZSigmaHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaHigh = 300;                 							// Default value.
			highSigmaZ.setText(String.valueOf(ZSigmaHigh)); 		// Update.
		}         
		double ChiSquareLow;        
		try {
			ChiSquareLow = Double.parseDouble(Chi_low.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareLow = 0.0;                 								// Default value.
			Chi_low.setText(String.valueOf(ChiSquareLow)); 						// Update.
		}  
		double ChiSquareHigh;        
		try {
			ChiSquareHigh = Double.parseDouble(Chi_high.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareHigh = 1.0;                 								// Default value.
			Chi_high.setText(String.valueOf(ChiSquareHigh)); 						// Update.
		}
		int PrecisionLow; // Initiate. 
		try {
			PrecisionLow = Integer.parseInt(lowPrecisionXY.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLow = 0;                 							// Default value.
			lowPrecisionXY.setText(String.valueOf(PrecisionLow)); 		// Update.
		}  
		int PrecisionHigh; // Initiate. 
		try {
			PrecisionHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHigh = 50;                 							// Default value.
			highPrecisionXY.setText(String.valueOf(PrecisionHigh)); 		// Update.
		} 
		int PrecisionLowZ; // Initiate. 
		try {
			PrecisionLowZ = Integer.parseInt(lowZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLowZ = 0;                 							// Default value.
			lowZprecision.setText(String.valueOf(PrecisionLowZ)); 		// Update.
		}  
		int PrecisionHighZ; // Initiate. 
		try {
			PrecisionHighZ = Integer.parseInt(highZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHighZ = 50;                 							// Default value.
			highZprecision.setText(String.valueOf(PrecisionHighZ)); 		// Update.
		}         
		boolean[] Include = new boolean[6];



		Include[0] = inclXYsigma.isSelected();
		Include[1] = inclZsigma.isSelected();        
		Include[2] = inclXYprecision.isSelected();
		Include[3] = inclZprecision.isSelected();
		Include[4] = inclChiSquare.isSelected();
		Include[5] = inclPhotonCount.isSelected();

		double[] lb = {
				SigmaLow,								// Allowed lower range of sigma_x in nm, user input.
				SigmaLow,								// Allowed lower range of sigma_y in nm, user input.
				ZSigmaLow,								// Allowed lower range of sigma_z in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_x in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_y in nm, user input.
				PrecisionLowZ,								// Allowed lower range of precision_z in nm, user input.
				ChiSquareLow,								// Allowed lower range of chi_square, user input.
				photonLow								// Allowed lower range of photon count, user input.
		};  				
		double[] ub = {
				SigmaHigh,						// Allowed upper range of sigma_x in nm, user input.
				SigmaHigh,						// Allowed upper range of sigma_y in nm, user input.
				ZSigmaHigh,						// Allowed upper range of sigma_z in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_x in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_y in nm, user input.
				PrecisionHighZ,						// Allowed upper range of precision_z in nm, user input.
				ChiSquareHigh,						// Allowed upper range of chi_square, user input.
				photonHigh					// Allowed upper range of photon count, user input.
		};


		cleanParticleList.run(lb,ub,Include);
		cleanParticleList.delete();

	}                                          

	/*
	 * Cluster analysis.
	 */

	private void ClusterAnalysisActionPerformed(java.awt.event.ActionEvent evt) {                                                
		/*
		 * Update table based on user parameter settings
		 */

		int photonLow; // Initiate. 
		try {
			photonLow = Integer.parseInt(lowPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonLow = 0;                 							// Default value.
			lowPhotonCount.setText(String.valueOf(photonLow)); 		// Update.
		}    

		int photonHigh; // Initiate. 
		try {
			photonHigh = Integer.parseInt(highPhotonCount.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			photonHigh = 5000;                 							// Default value.
			highPhotonCount.setText(String.valueOf(photonHigh)); 		// Update.
		}  
		int SigmaLow; // Initiate. 
		try {
			SigmaLow = Integer.parseInt(lowSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaLow = 300;                 							// Default value.
			lowSigma.setText(String.valueOf(SigmaLow)); 		// Update.
		}  
		int SigmaHigh; // Initiate. 
		try {
			SigmaHigh = Integer.parseInt(highSigma.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			SigmaHigh = 300;                 							// Default value.
			highSigma.setText(String.valueOf(SigmaHigh)); 		// Update.
		}  
		int ZSigmaLow; // Initiate. 
		try {
			ZSigmaLow = Integer.parseInt(lowSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaLow = 0;                 							// Default value.
			lowSigmaZ.setText(String.valueOf(ZSigmaLow)); 		// Update.
		}  
		int ZSigmaHigh; // Initiate. 
		try {
			ZSigmaHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ZSigmaHigh = 300;                 							// Default value.
			highSigmaZ.setText(String.valueOf(ZSigmaHigh)); 		// Update.
		}         
		double ChiSquareLow;        
		try {
			ChiSquareLow = Double.parseDouble(Chi_low.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareLow = 0.0;                 								// Default value.
			Chi_low.setText(String.valueOf(ChiSquareLow)); 						// Update.
		}  
		double ChiSquareHigh;        
		try {
			ChiSquareHigh = Double.parseDouble(Chi_high.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			ChiSquareHigh = 1.0;                 								// Default value.
			Chi_high.setText(String.valueOf(ChiSquareHigh)); 						// Update.
		}
		int PrecisionLow; // Initiate. 
		try {
			PrecisionLow = Integer.parseInt(lowPrecisionXY.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLow = 0;                 							// Default value.
			lowPrecisionXY.setText(String.valueOf(PrecisionLow)); 		// Update.
		}  
		int PrecisionHigh; // Initiate. 
		try {
			PrecisionHigh = Integer.parseInt(highSigmaZ.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHigh = 50;                 							// Default value.
			highPrecisionXY.setText(String.valueOf(PrecisionHigh)); 		// Update.
		} 
		int PrecisionLowZ; // Initiate. 
		try {
			PrecisionLowZ = Integer.parseInt(lowZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionLowZ = 0;                 							// Default value.
			lowZprecision.setText(String.valueOf(PrecisionLowZ)); 		// Update.
		}  
		int PrecisionHighZ; // Initiate. 
		try {
			PrecisionHighZ = Integer.parseInt(highZprecision.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			PrecisionHighZ = 50;                 							// Default value.
			highZprecision.setText(String.valueOf(PrecisionHighZ)); 		// Update.
		}         
		boolean[] Include = new boolean[6];



		Include[0] = inclXYsigma.isSelected();
		Include[1] = inclZsigma.isSelected();        
		Include[2] = inclXYprecision.isSelected();
		Include[3] = inclZprecision.isSelected();
		Include[4] = inclChiSquare.isSelected();
		Include[5] = inclPhotonCount.isSelected();

		double[] lb = {
				SigmaLow,								// Allowed lower range of sigma_x in nm, user input.
				SigmaLow,								// Allowed lower range of sigma_y in nm, user input.
				ZSigmaLow,								// Allowed lower range of sigma_z in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_x in nm, user input.
				PrecisionLow,								// Allowed lower range of precision_y in nm, user input.
				PrecisionLowZ,								// Allowed lower range of precision_z in nm, user input.
				ChiSquareLow,								// Allowed lower range of chi_square, user input.
				photonLow								// Allowed lower range of photon count, user input.
		};  				
		double[] ub = {
				SigmaHigh,						// Allowed upper range of sigma_x in nm, user input.
				SigmaHigh,						// Allowed upper range of sigma_y in nm, user input.
				ZSigmaHigh,						// Allowed upper range of sigma_z in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_x in nm, user input.
				PrecisionHigh,						// Allowed upper range of precision_y in nm, user input.
				PrecisionHighZ,						// Allowed upper range of precision_z in nm, user input.
				ChiSquareHigh,						// Allowed upper range of chi_square, user input.
				photonHigh					// Allowed upper range of photon count, user input.
		};


		cleanParticleList.run(lb,ub,Include);
		int Epsilon; // Initiate. 
		try {
			Epsilon = Integer.parseInt(epsilon.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			Epsilon = 10;                 							// Default value.
			epsilon.setText(String.valueOf(Epsilon)); 		// Update.
		}
		int minConnectingPoints; // Initiate. 
		try {
			minConnectingPoints = Integer.parseInt(minPts.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			minConnectingPoints = 5;                 							// Default value.
			minPts.setText(String.valueOf(minConnectingPoints)); 		// Update.
		}
		int inputPixelSize; // Initiate. 
		try {
			inputPixelSize = Integer.parseInt(pixelSize.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			inputPixelSize = 100;                 							// Default value.
			pixelSize.setText(String.valueOf(inputPixelSize)); 		// Update.
		}  
		int DesiredPixelSize; // Initiate. 
		try {
			DesiredPixelSize = Integer.parseInt(desiredPixelSize.getText());        		
		} catch (NumberFormatException e) { 								// If user wrote non numerical test into the field.
			DesiredPixelSize = 5;                 							// Default value.
			desiredPixelSize.setText(String.valueOf(DesiredPixelSize)); 		// Update.
		}  
		int PixelRatio = Math.round(inputPixelSize/DesiredPixelSize);
		DBClust.Ident(Epsilon, minConnectingPoints,PixelRatio); // Unsure if it handles 3D points, need to check. Not yet multi channel.		
	}                                               

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SMLocalizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SMLocalizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SMLocalizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SMLocalizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SMLocalizerGUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify                     	                 
    private javax.swing.JButton AlignChannels;
    private javax.swing.JCheckBox ChannelAlign;
    private javax.swing.JTextField Chi_high;
    private javax.swing.JTextField Chi_low;
    private javax.swing.JButton ClusterAnalysis;
    private javax.swing.JLabel MinPartDistLabel;
    private javax.swing.JLabel MinPtsLabel;
    private javax.swing.JLabel MinPtsLabel_ChAlign;
    private javax.swing.JTextField MinSignal;
    private javax.swing.JLabel MinSignal_Label;
    private javax.swing.JButton PlotDistr;
    private javax.swing.JButton Process;
    private javax.swing.JLabel advancedSettingsLabel;
    private javax.swing.JLabel basicSettingsLabel;
    private javax.swing.JTextField binCount;
    private javax.swing.JLabel binCountLabel;
    private javax.swing.JButton cleanTable;
    private javax.swing.JButton correctBackground;
    private javax.swing.JTextField desiredPixelSize;
    private javax.swing.JCheckBox doClusterAnalysis;
    private javax.swing.JButton driftCorrect;
    private javax.swing.JLabel driftLabel;
    private javax.swing.JTextField epsilon;
    private javax.swing.JLabel epsilonLabel;
    private javax.swing.JComboBox<String> gWindow;
    private javax.swing.JLabel gWindowLabel;
    private javax.swing.JLabel headerSelect;
    private javax.swing.JTextField highChAlignBinCount;
    private javax.swing.JTextField highDriftBinCount;
    private javax.swing.JTextField highPhotonCount;
    private javax.swing.JTextField highPrecisionXY;
    private javax.swing.JTextField highSigma;
    private javax.swing.JTextField highSigmaZ;
    private javax.swing.JTextField highZprecision;
    private javax.swing.JCheckBox inclChiSquare;
    private javax.swing.JCheckBox inclPhotonCount;
    private javax.swing.JCheckBox inclXYprecision;
    private javax.swing.JCheckBox inclXYsigma;
    private javax.swing.JCheckBox inclZprecision;
    private javax.swing.JCheckBox inclZsigma;
    private javax.swing.JButton localize;
    private javax.swing.JTextField lowChAlignBinCount;
    private javax.swing.JTextField lowDriftBinCount;
    private javax.swing.JTextField lowPhotonCount;
    private javax.swing.JTextField lowPrecisionXY;
    private javax.swing.JTextField lowSigma;
    private javax.swing.JTextField lowSigmaZ;
    private javax.swing.JTextField lowZprecision;
    private javax.swing.JLabel maxLabel1;
    private javax.swing.JLabel maxLabel2;
    private javax.swing.JLabel maxLabel3;
    private javax.swing.JTextField medianWindow;
    private javax.swing.JLabel medianWindowLabel;
    private javax.swing.JLabel minLabel1;
    private javax.swing.JLabel minLabel2;
    private javax.swing.JLabel minLabel3;
    private javax.swing.JLabel minPartClabel;
    private javax.swing.JTextField minParticleDistance;
    private javax.swing.JTextField minPts;
    private javax.swing.JLabel outpPixelSize;
    private javax.swing.JTextField pixelSize;
    private javax.swing.JLabel pixelSizeLabel;
    private javax.swing.JTextField positivePixels;
    private javax.swing.JLabel positivePixelsLabel;
    private javax.swing.JButton render;
    private javax.swing.JLabel screenLabel;
    private javax.swing.JLabel stepSizeLabe;
    private javax.swing.JLabel stepSizeLabel_ChAlign;
    private javax.swing.JTextField stepsizeXY;
    private javax.swing.JTextField stepsizeXYchAlign;
    private javax.swing.JTextField stepsizeZ;
    private javax.swing.JTextField stepsizeZchAlign;
    private javax.swing.JTextField xyDrift;
    private javax.swing.JLabel xyDriftLabel;
    private javax.swing.JTextField zDrift;
    private javax.swing.JLabel zDriftLabel;
    // End of variables declaration                      
}