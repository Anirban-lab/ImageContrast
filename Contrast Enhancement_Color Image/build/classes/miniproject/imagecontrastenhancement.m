function imagecontrastenhancement( Source, Destination )

    O_Im = imread(Source);
    
    if size(O_Im,3)==1
        En_Im = histeq(O_Im);
        [Iny, x] = imhist(O_Im);
        [Outy, x] = imhist(En_Im);
        f = figure('name','Image Contrast Enhancement using Histogram Equalization','NumberTitle','off'),
                 set(gcf, 'Position', get(0, 'Screensize'));
%                    set(gcf,'JavaFrame');
            subplot(2,2,1),imshow(O_Im);
                 title('Image Before Histogram Equalization');
            subplot(2,2,2),imshow(En_Im);
                 title('Image After Histogram Equalization');
            subplot(2,2,3),plot(x, Iny, 'Black');
                 title('Histogram Before Histogram Equalization');
            subplot(2,2,4),plot(x, Outy, 'Black');
                 title('Histogram After Histogram Equalization');
            uiwait(f);
    else
        HSV = rgb2hsv(O_Im);
        Heq = histeq(HSV(:,:,3));
        HSV(:,:,3) = Heq;
        En_Im = hsv2rgb(HSV);
        [OyRed, x] = imhist(O_Im(:,:,1));
        [OyGreen, x] = imhist(O_Im(:,:,2));
        [OyBlue, x] = imhist(O_Im(:,:,3));
        [EyRed, x] = imhist(En_Im(:,:,1));
        [EyGreen, x] = imhist(En_Im(:,:,2));
        [EyBlue, x] = imhist(En_Im(:,:,3));
        f = figure('name','Image Contrast Enhancement using Histogram Equalization','NumberTitle','off'),
                 set(gcf, 'Position', get(0, 'Screensize'));
                 f = gcf;
%                    set(gcf,'JavaFrame');
            subplot(2,2,1),imshow(O_Im);
                 title('Image Before Histogram Equalization');
            subplot(2,2,2),imshow(En_Im);
                 title('Image After Histogram Equalization');
            subplot(2,2,3),plot(x, OyRed, 'Red', x, OyGreen, 'Green', x, OyBlue, 'Blue');
                 title('Histogram Before Histogram Equalization');
            subplot(2,2,4),plot(x, EyRed, 'Red', x, EyGreen, 'Green', x, EyBlue, 'Blue');
                 title('Histogram After Histogram Equalization');
            uiwait(f);
    end
    imwrite(En_Im,Destination);
    

end
